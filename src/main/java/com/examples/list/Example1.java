package com.examples.list;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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

		System.out.println("");
		System.out.println("Remove just one Dev with age == 5 and order by salary dec");
		listDevs.removeIf(s -> s.getAge() == 5);
		listDevs.sort((s1,s2) -> s2.getSalary().compareTo(s1.getSalary()));
		listDevs.forEach((developer) -> System.out.println(" " + developer));

		System.out.println("");
		System.out.println("List of Departments summing their salaries");
		Map<String, BigDecimal> groupByDep = new HashMap<>();
		listDevs = getDevelopers();
		groupByDep = listDevs.stream().collect(Collectors.groupingBy(Developer::getDepart, Collectors.reducing(BigDecimal.ZERO, Developer::getSalary, BigDecimal::add)));
		groupByDep.forEach((a,b) -> System.out.println(a + " " + b));
	}

	private static List<Developer> getDevelopers() {

		List<Developer> result = new ArrayList<Developer>();

		result.add(new Developer("luana", new BigDecimal("70000"), 5, "IT"));
		result.add(new Developer("andrea", new BigDecimal("80000"), 37, "IT"));
		result.add(new Developer("gleison", new BigDecimal("100000"), 38, "ENG"));
		result.add(new Developer("maya", new BigDecimal("170000"), 10, "ENG"));

		return result;

	}
}

class Developer {
	private String name;
	private BigDecimal salary;
	private int age;
	private String depart;

	public Developer(String name, BigDecimal salary, int i, String depart) {
		this.name = name;
		this.salary = salary;
		this.age = i;
		this.depart = depart;
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

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String toString() {
		return this.name;
	}
}
