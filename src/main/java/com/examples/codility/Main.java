package com.examples.codility;

import java.util.*;

public class Main {


    public static void main(String args[]){
        List<String> a = new ArrayList<>();
        a.add("Banana");
        a.add("Avocado");
        a.add("Cat");
        a.add("Cat");
        a.add("Banana");

        Set<String> b = new HashSet<>(a);
        b.stream().sorted(Comparator.naturalOrder());
        System.out.println(b.toString());


        Set<String> c = new HashSet<>();
        c.add("Pineapple");
        c.add("Cinammon");
        c.add("Bluberry");
        c.add("Strawberry");
        c.add("Strawberry");

        List<String> d = new ArrayList<>();
        d.stream().sorted(Comparator.naturalOrder());
        System.out.println(c.toString());
    }

}
