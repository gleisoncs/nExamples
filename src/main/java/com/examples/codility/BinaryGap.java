package com.examples.codility;

public class BinaryGap {
    public static void main(String args[]) {
        System.out.println(new BinaryGap().solution(1041));
    }

    public int solution(int n) {
        int binaryGap = 0;

        // remove trailing zeroes if not counted; credit to Peter Taylor
        while (n % 2 == 0) {
            n /= 2;
        }

        for (int j = 0; n > 0; n /= 2) {
            if (n % 2 == 0) {
                j++;
            } else {
                if (j > binaryGap) {
                    binaryGap = j;
                }

                j = 0;
            }
        }

        return binaryGap;
    }
}
