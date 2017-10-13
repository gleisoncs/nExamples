package com.examples.list;

import java.util.Arrays;
import java.util.List;

public class Example5 {
	public static void main(String args[]) {

		List<Person> persons = Arrays.asList(
				new Person("mkyong", 20), 
				new Person("michael", 21),
				new Person("lawrence", 23),
				new Person("michael", 23));

		int age = persons.stream().filter(x -> "michael".equals(x.getName())).map(Person::getAge).findAny().orElse(0);

		String name = persons.stream().filter(x -> 23 == x.getAge()).map(Person::getName).findFirst().orElse(null);
		
		System.out.println(age);
		System.out.println(name);
	}
}

class Person {
	private String name;
	private int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}