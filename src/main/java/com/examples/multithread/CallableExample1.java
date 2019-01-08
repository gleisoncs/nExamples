package com.examples.multithread;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.*;

public class CallableExample1 {
    public static void main(String args[]){
        RestTemplate restTemplate = new RestTemplate();

        ExecutorService service = Executors.newFixedThreadPool(2);
        Callable<String> cal1 = () -> {
            String a = restTemplate.getForObject("http://localhost:8081/", String.class);
            return a;
        };
        Callable<String> cal2 = () -> {
            String a = restTemplate.getForObject("http://localhost:8081/", String.class);
            return a;
        };

        ArrayList<Callable<String>> listOfCallables = new ArrayList<>();
        listOfCallables.add(cal1);
        listOfCallables.add(cal2);
        List<Future<String>> futures = null;
        try {
            futures = service.invokeAll(listOfCallables);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        service.shutdown();
        try {
            service.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(futures.get(0));
    }
}
