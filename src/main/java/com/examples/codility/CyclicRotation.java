package com.examples.codility;

import java.util.Arrays;

public class CyclicRotation {
    public static void main(String args[]) {
        rubish();
        int a[] = {3, 8, 9, 7, 6};
        new CyclicRotation().solution(a, 3);
    }

    private static void rubish() {
        //System.out.println(3 % 5);

        int a[] = {2, 3, 1, 5};
        Arrays.sort(a);
        for (int x = 0; x < a.length-1; x ++){
            if (a[x]+1 != (a[x+1])){
                System.out.println((a[x] + 1));
            }
        }

        System.exit(0);
    }

    public int[] solution(int[] a, int k) {
        int[] x = new int[a.length];

        for (int i = 0; i < a.length; i++)
            x[(i + k) % a.length] = a[i];

        return x;
    }
}
