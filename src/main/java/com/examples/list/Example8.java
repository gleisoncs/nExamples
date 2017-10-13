package com.examples.list;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Example8 {
	private File file;

	public Example8(File file) {
		this.file = file;
	}

	// Processes the given portion of the file.
	// Called simultaneously from several threads.
	// Use your custom return type as needed, I used String just to give an
	// example.
	public String processPart(long start, long end) throws Exception {
		InputStream is = new FileInputStream(file);
		is.skip(start);
		// do a computation using the input stream,
		// checking that we don't read more than (end-start) bytes
		System.out.println("Computing the part from " + start + " to " + end);
		Thread.sleep(1000);
		System.out.println("Finished the part from " + start + " to " + end);

		is.close();
		return "Some result";
	}

	// Creates a task that will process the given portion of the file,
	// when executed.
	public Callable<String> processPartTask(final long start, final long end) {
		return new Callable<String>() {
			public String call() throws Exception {
				return processPart(start, end);
			}
		};
	}

	// Splits the computation into chunks of the given size,
	// creates appropriate tasks and runs them using a
	// given number of threads.
	public void processAll(int noOfThreads, int chunkSize) throws Exception {
		int count = (int) ((file.length() + chunkSize - 1) / chunkSize);
		java.util.List<Callable<String>> tasks = new ArrayList<Callable<String>>(count);
		for (int i = 0; i < count; i++)
			tasks.add(processPartTask(i * chunkSize, Math.min(file.length(), (i + 1) * chunkSize)));
		ExecutorService es = Executors.newFixedThreadPool(noOfThreads);

		java.util.List<Future<String>> results = es.invokeAll(tasks);
		es.shutdown();

		// use the results for something
		for (Future<String> result : results)
			System.out.println(result.get());
	}

	public static void main(String argv[]) throws Exception {
		ClassLoader classLoader = Example7.class.getClassLoader();
		File file = new File(classLoader.getResource("example4.csv").getFile());
		String FILENAME = file.toString();

		Example8 s = new Example8(new File(FILENAME));
		s.processAll(8, 1000);
	}
}
