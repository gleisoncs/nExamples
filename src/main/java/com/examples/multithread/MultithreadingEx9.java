package com.examples.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultithreadingEx9 {
	public static void main(String args[]) {

		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(() -> {
			String threadName = Thread.currentThread().getName();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
			}
			System.out.println("Hello " + threadName);
		});

		try {
			System.out.println("attempt to shutdown executor");
			executor.shutdown();
			System.out.println("attempt to shutdown executor 2");
			executor.awaitTermination(5, TimeUnit.SECONDS);
			System.out.println("attempt to shutdowned");
		} catch (InterruptedException e) {
			System.err.println("tasks interrupted");
		} finally {
			if (!executor.isTerminated()) {
				System.err.println("cancel non-finished tasks");
			}
			executor.shutdownNow();
			System.out.println("shutdown finished");
		}

	}
}
