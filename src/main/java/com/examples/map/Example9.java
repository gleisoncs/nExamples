package com.examples.map;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Example9 {

	public static void main(String args[]) throws IOException {
        List<String> listString1 = new ArrayList<String>();
        listString1.add("2");
        listString1.add("4");
        listString1.add("31");
        
        System.out.println("Initial List1:\n" + listString1);
        System.out.println("---------------------------------");

        List<String> listString2 = new ArrayList<String>();
        listString2.add("4");
        listString2.add("31");
        listString2.add("2");
        
        System.out.println("Initial List2:\n" + listString2);
        System.out.println("---------------------------------");
        
        System.out.println("Lists listString2 == listString1:" + listString2.containsAll(listString1));
        System.out.println("Lists listString1 == listString2:" + listString1.containsAll(listString2));
	}
}