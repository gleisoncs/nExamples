package com.examples.hackerhank;

import com.examples.coursera.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BirthdayCake {
    public static void main(String args[]){
        int[] a = new int[]{1,2,3,3};
        int n = a.length;
        int tallest = 0;
        int frequency = 0;


        for(int i=0; i < n; i++){
            int height = a[i];

            if(height > tallest){
                tallest = height;
                frequency = 1;
            }
            else if(height == tallest) frequency++;
        }
        System.out.println(frequency);
    }
}
