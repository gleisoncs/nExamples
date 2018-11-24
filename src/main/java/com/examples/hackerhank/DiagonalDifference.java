package com.examples.hackerhank;

public class DiagonalDifference {

    static int diagonalDifference(int[][] arr) {
        int row=0;
        int column=arr[0].length - 1;
        int solution = 0;
        for(int index=0;index<arr.length;index++){
            solution -= arr[row][row] - arr[row++][column--];
        }
        return Math.abs(solution);
    }

    public static void main(String args[]){
        System.out.println(diagonalDifference(new int[][]{{11,2,4},{4,5,6},{10,8,-12}}));
    }
}
