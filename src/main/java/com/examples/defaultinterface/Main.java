package com.examples.defaultinterface;

public class Main {

	public static void main(String[] args) {
		Formula formula = new Formula() {
		    public double calculate(int a) {
		        return sqrt(a * 100);
		    }
		};

		System.out.println(formula.calculate(100));
		System.out.println(formula.sqrt(16)); 
	}

}
