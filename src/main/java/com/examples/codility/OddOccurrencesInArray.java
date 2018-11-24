package com.examples.codility;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OddOccurrencesInArray {

    public static void main(String args[]){
        int [] a = {9, 3, 9, 3, 9, 7, 9};
        System.out.println(OddOccurrencesInArray.solution(a));
    }

    public static int solution(int[] a) {
        int length = a.length;
        Stream s = Stream.of(a);

        List<Integer> collect = Arrays.stream(a).boxed().collect(Collectors.toList());
        Map<Integer, Long> result =
                collect.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );

        Map<Integer, Long> collect1 = result.entrySet().stream()
                .filter(map -> map.getValue() == 1)
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));

        int d = collect1.entrySet().stream().findFirst().get().getKey().intValue();
        return d;
    }
}
