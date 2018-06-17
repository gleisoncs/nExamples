package com.examples.multithread;

import static java.lang.System.out;

public class MultithreadingEx10 {
	Runnable r1 = () -> out.println(this);
	Runnable r2 = () -> out.println(toString());

	public String toString() {
		return "Hello, world!";
	}

	public static void main(String[] args) {
		new MultithreadingEx10().r1.run(); // Hello, world!
		new MultithreadingEx10().r2.run(); // Hello, world!
	}
}
