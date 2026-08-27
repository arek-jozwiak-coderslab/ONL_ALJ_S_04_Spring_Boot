package com.example.demo.football;


import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class Main {

    private static final String API_KEY
            = "eee5028bd4f1a9645f0de3b18aa4c17c11a0eedd815aeaacf2cae4d5801e8969";
    private static final String API_URL
            = "https://apiv3.apifootball.com/?action=get_countries&APIkey={apiKey}";

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        CountryDTO[] forObject = restTemplate.getForObject(API_URL,
                CountryDTO[].class, API_KEY);
        Arrays.stream(forObject).forEach(System.out::println);
    }
}