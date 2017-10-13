package com.examples.map;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

import com.examples.list.Example7;

public class Example8 {

	public static void main(String args[]) throws IOException {
		ClassLoader classLoader = Example7.class.getClassLoader();
		File file = new File(classLoader.getResource("example8.csv").getFile());
		String FILENAME = file.toString();

		ConcurrentHashMap<String, LongAdder> wordCounts = new ConcurrentHashMap<>();

		Files.readAllLines(Paths.get(FILENAME)).parallelStream() // Start streaming the lines
				.map(line -> line.split(";")) // Split line into individual words
				.flatMap(Arrays::stream) // Convert stream of String[] to stream of String
				.parallel() // Convert to parallel stream
				.filter(w -> w.matches("\\w+")) // Filter out non-word items
				.map(String::toLowerCase) // Convert to lower case
				.forEach(word -> { // Use an AtomicAdder to tally word counts
					if (!wordCounts.containsKey(word)) // If a hashmap entry for the word doesn't exist yet
						wordCounts.put(word, new LongAdder()); // Create a new LongAdder
					wordCounts.get(word).increment(); // Increment the LongAdder for each instance of a word
				});
		System.out.println(wordCounts);
	}
}