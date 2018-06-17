package com.examples.list;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Example1 {
	public static void main(String[] args) {

		List<Developer> listDevs = getDevelopers();

		System.out.println("Before Sort");
		for (Developer developer : listDevs) {
			System.out.println(" " + developer);
		}

		System.out.println("");
		System.out.println("After Sort");

		// lambda here!
		listDevs.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));

		// java 8 only, lambda also, to print the List
		listDevs.forEach((developer) -> System.out.println(" " + developer));
		
		System.out.println("");
		System.out.println("After Sort per age");
		listDevs.sort((o1, o2) -> o1.getAge() - o2.getAge());
		listDevs.forEach((developer) -> System.out.println(" " + developer));
		
		System.out.println("");
		System.out.println("After Sort per age decrecent");
		listDevs.sort(Comparator.comparing(Developer::getAge, (s1, s2) -> { return s2.compareTo(s1); }));
		listDevs.forEach((developer) -> System.out.println(" " + developer));

	}

	private static List<Developer> getDevelopers() {

		List<Developer> result = new ArrayList<Developer>();

		result.add(new Developer("luana", new BigDecimal("70000"), 5));
		result.add(new Developer("andrea", new BigDecimal("80000"), 37));
		result.add(new Developer("gleison", new BigDecimal("100000"), 38));
		result.add(new Developer("maya", new BigDecimal("170000"), 10));

		return result;

	}
}

class Developer {
	private String name;
	private BigDecimal salary;
	private int age;

	public Developer(String name, BigDecimal salary, int i) {
		this.name = name;
		this.salary = salary;
		this.age = i;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return this.name;
	}
}
