package com.examples.createannotation;

import org.reflections.Reflections;

public class Main {

	public static void main(String[] args) {
		System.out.println("Scanning using Reflections:");

		Reflections ref = new Reflections("com.examples.createannotation");
		for (Class<?> cl : ref.getTypesAnnotatedWith(Huep.class)) {
			Huep findable = cl.getAnnotation(Huep.class);
			System.out.printf("Found class: %s, with meta name: %s%n", cl.getSimpleName(), findable.tags());
		}
	}
}
