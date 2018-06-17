package com.examples.list;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example12 {

	public static void main(String args[]) {
		// 3 apples, 2 banana, others 1
		List<Item> items = Arrays.asList(
				new Item("apple", 10, new Double("9.99")),
				new Item("banana", 20, new Double("19.99")), 
				new Item("orange", 10, new Double("29.99")),
				new Item("watermelon", 10, new Double("29.99")), 
				new Item("papaya", 20, new Double("9.99")),
				new Item("apple", 10, new Double("9.99")), 
				new Item("banana", 10, new Double("19.99")),
				new Item("apple", 20, new Double("9.99"))
		);

		Map<String, Long> counting = items.stream().collect(Collectors.groupingBy(Item::getName, Collectors.counting()));
		System.out.println("counting =" + counting);

		Map<String, Integer> sum = items.stream().collect(Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));
		System.out.println("sum =" + sum);

		Map<String, Double> avg = items.stream().collect(Collectors.groupingBy(Item::getName, Collectors.averagingInt(p -> p.getQty())));
		System.out.println("avg =" + avg);
		
		Map<String, Double> avgPrice = items.stream().collect(Collectors.groupingBy(Item::getName, Collectors.averagingDouble(p -> p.getPrice())));
		System.out.println("avg =" + avgPrice);

		IntSummaryStatistics qtdeSummary = items.stream().collect(Collectors.summarizingInt(p -> p.getQty()));
		System.out.println(qtdeSummary);

	}
}

class Item {

	private String name;
	private int qty;
	private Double price;

	public Item(String name, int qty, Double price) {
		super();
		this.name = name;
		this.qty = qty;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
