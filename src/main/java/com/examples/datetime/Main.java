package com.examples.datetime;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        getSimpleFormat("07:05:45PM");
//        getSimpleFormat("12:00:00AM");
//        getSimpleFormat("2018-12-20T09:41:42.2194263Z");
    }

    private static void getSimpleFormat(String s) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyy-MM-dd'T'HH:mm:ss");
        String result = LocalTime.parse(s, fmt).toString();
        System.out.println(result);
    }
}
