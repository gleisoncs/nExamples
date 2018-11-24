package com.examples.hackerhank;

import java.util.*;

public class MiniMaxSum {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        long sum = 0;
        int count = 0;
        long[] result = new long[arr.length];
        for (int x = 0; x < arr.length; x++){
            for (int y = 0; y < arr.length; y++){
                if (x != y){
                    sum = sum + arr[y];
                }
            }
            result[x] = sum;
            sum = 0;
        }
        Arrays.sort(result);
        System.out.println(String.format("%s %s", result[0], result[result.length -1]));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
