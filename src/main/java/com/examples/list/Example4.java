package com.examples.list;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Example4 {

	private static String FILENAME = null;

	static {
		ClassLoader classLoader = Example7.class.getClassLoader();
		File file = new File(classLoader.getResource("example4.csv").getFile());
		FILENAME = file.toString();
	}
	
	public static void main(String args[]) throws IOException {
		printStream();
		printList();
		printScanner();
		printFiles();
		printBufferedReader();
	}

	private static void printFiles() throws IOException {
		Files.lines(Paths.get(FILENAME)).map(line -> line.split(";")) // Stream<String[]>
				.distinct() // Stream<String[]>
				.forEach(System.out::println);
	}

	private static void printScanner() throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(FILENAME));
		while (scanner.hasNext()) {
			System.out.println(scanner.next());
		}
		scanner.close();
	}

	private static void printList() throws IOException {
		List<String> list = new ArrayList<>();

		try (BufferedReader reader = Files.newBufferedReader(Paths.get(FILENAME))) {
			list = reader.lines().collect(Collectors.toList());
		}

		list.forEach(System.out::println);
	}

	private static void printBufferedReader() throws IOException {
		try (BufferedReader reader = Files.newBufferedReader(Paths.get(FILENAME))) {
			long countPrints = reader.lines()
					// .filter(line -> line.contains("print"))
					.count();
			System.out.println(countPrints);
		}
	}

	private static void printStream() throws IOException {
		Function<String, Employee> mapLineToEmployee = new Function<String, Employee>() {
			public Employee apply(String line) {
				String[] listOfPerson = line.split(";");
				return new Employee(listOfPerson[0], listOfPerson[1], new BigDecimal(listOfPerson[2]),
						new BigDecimal(listOfPerson[3]));
			}
		};

		try {
			List<Employee> listOfEmployee = Files.lines(Paths.get(FILENAME)).map(mapLineToEmployee)
					.collect(Collectors.toList());

			long milisec = System.currentTimeMillis();

			List<BigDecimal> newList = new ArrayList<>();
			BigDecimal sum = listOfEmployee.stream().map(Employee::getValue).peek(newList::add).reduce(BigDecimal.ZERO,
					BigDecimal::add);

			long milisecDuo = System.currentTimeMillis() - milisec;
			System.out.println(milisecDuo + " " + sum);

			long milisecTre = System.currentTimeMillis();
			ResultHolder resultHolder = listOfEmployee.stream().map(Employee::getValue).collect(ResultHolder::new,
					(r, p) -> {
						r.list.add(p);
						r.sum = r.sum.add(p);
					}, (r1, r2) -> {
						r1.list.addAll(r2.list);
						r1.sum = r1.sum.add(r2.sum);
					});

			long milisecQua = System.currentTimeMillis() - milisecTre;
			// System.out.println(resultHolder.list);
			System.out.println(milisecQua + " " + resultHolder.sum);

		} catch (Exception e) {
		}
	}
}

class ResultHolder {
	List<BigDecimal> list = new ArrayList<>();
	BigDecimal sum = BigDecimal.ZERO;
}

class Employee {
	private String number;
	private String name;
	private BigDecimal age;
	private BigDecimal value;

	Employee(String number, String name, BigDecimal age, BigDecimal value) {
		this.number = number;
		this.name = name;
		this.age = age;
		this.value = value;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getAge() {
		return age;
	}

	public void setAge(BigDecimal age) {
		this.age = age;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
}