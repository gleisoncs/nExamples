package com.examples.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultithreadingEx1 {
	public static void main(String args[]) {
		ExecutorService service = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 11; i++) {
			service.submit(new Task(i));
		}
		service.shutdown();
	}
}

final class Task implements Runnable {
	private int taskId;

	public Task(int id) {
		this.taskId = id;
	}

	@Override
	public void run() {
		System.out.println("Task ID : " + this.taskId + " performed by " + Thread.currentThread().getName());
	}
}
