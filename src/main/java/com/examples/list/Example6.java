package com.examples.list;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Example6 implements Runnable {

	private static String FILENAME = null;

	static {
		ClassLoader classLoader = Example7.class.getClassLoader();
		File file = new File(classLoader.getResource("data1.csv").getFile());
		FILENAME = file.toString();
	}
	
	private static final int PRODUCER_COUNT = 1;
	private static final int CONSUMER_COUNT = 2;
	private final static BlockingQueue<String> linesReadQueue = new ArrayBlockingQueue<String>(30);

	private boolean isConsumer = false;
	private static boolean producerIsDone = false;

	public Example6(boolean consumer) {
		this.isConsumer = consumer;
	}

	public static void main(String[] args) {

		long startTime = System.nanoTime();

		ExecutorService producerPool = Executors.newFixedThreadPool(PRODUCER_COUNT);
		producerPool.submit(new Example6(false));

		ExecutorService consumerPool = Executors.newFixedThreadPool(CONSUMER_COUNT);
		consumerPool.submit(new Example6(true));

		producerPool.shutdown();
		consumerPool.shutdown();

		long endTime = System.nanoTime();
		long elapsedTimeInMillis = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS);
		System.out.println("Total elapsed time: " + elapsedTimeInMillis + " ms");
	}

	private void readFile() {
		Path file = Paths.get(FILENAME);
		try {
			Stream<String> lines = Files.lines(file, StandardCharsets.UTF_8);

			for (String line : (Iterable<String>) lines::iterator) {
				linesReadQueue.put(line);
			}
			lines.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		producerIsDone = true;
		System.out.println(Thread.currentThread().getName() + " producer is done");
	}

	@Override
	public void run() {
		if (isConsumer) {
			consume();
		} else {
			readFile();
		}
	}

	private void consume() {
		try {
			while (!producerIsDone || (producerIsDone && !linesReadQueue.isEmpty())) {
				String lineToProcess = linesReadQueue.take();
				System.out.println(lineToProcess);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + " consumer is done");
	}
}