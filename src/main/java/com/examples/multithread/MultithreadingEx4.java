package com.examples.multithread;

public class MultithreadingEx4 {

	static public void main(String[] args) throws InterruptedException {
		Runnable task = () -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("Hello " + threadName);
		};

		task.run();

		Thread thread = new Thread(task);
		thread.start();
		System.out.println("Done!");

	}
}