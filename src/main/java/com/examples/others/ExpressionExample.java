package com.examples.others;

public class ExpressionExample {
	public static void main(String[] args) {
		System.out.println(countMins(18, 40));
	}
	
	private static String countMins(int actualMin, int range) {
		String expression = "";
		for (int x = actualMin; x >= 0; x = x-range){
			expression = expression + "," + x;
		}
		for (int y = actualMin+range; y <= 59; y = y+range){
			expression = expression + "," + y;
		}
		return expression.substring(1);
	}
}
