package com.examples.multithread;

public class MultithreadingEx5 {

	public static volatile long count = 0;

	public static void main(String[] args) {
		Runnable task1 = () -> {
			for (long x = 0; x <= 10; x++) {
				count++;
			}
		};
		Runnable task2 = () -> {
			for (long x = 0; x <= 10; x++) {
				count++;
			}
		};
		task1.run();
		task2.run();
		new Thread(task1).start();
		new Thread(task2).start();
		System.out.println(count);
	}
}
