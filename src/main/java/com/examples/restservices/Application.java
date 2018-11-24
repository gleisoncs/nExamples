package com.examples.restservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Arrays;

public class Application {

    private static String eventfulURL = "http://api.eventful.com/rest/events/search?app_key=6FMhM2B9rmMVbhCk&keywords=music&date=future&page=2&location=curitiba";
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        callMethod1();
//        callMethod2();
//        callMethod3();
    }

    private static void callMethod1() {
        RestTemplate restTemplate = new RestTemplateBuilder().setConnectTimeout(3000).setReadTimeout(3000).build();
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        log.info(quote.toString());
    }

    private static void callMethod2() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<Search> result = restTemplate.exchange(eventfulURL, HttpMethod.GET, entity, Search.class);
        result.getBody().getEvents().forEach(a -> System.out.println(a.getTitle() + " - " + a.getVenue() + " - " + new SimpleDateFormat("dd/mm/yyyy hh:mm").format(a.getStartTime())));
    }

    private static void callMethod3(){
        RestTemplate restTemplate = new RestTemplate();
        Coin[] coins = restTemplate.getForObject("https://api.coinmarketcap.com/v1/ticker/", Coin[].class);

        // VERGE
        Object[] vergeArray = Arrays.stream(coins).filter(x -> x.getName().equalsIgnoreCase("eos")).toArray();
        log.info("Name :" + ((Coin) vergeArray[0]).getName());
        log.info(" Price USD :" + Double.valueOf(((Coin) vergeArray[0]).getPrice_usd()));
        log.info("-------------------------------------------------");
    }

    private static void callMethod4(){
        //connect just with http
    }
}
