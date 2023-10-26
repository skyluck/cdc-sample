package com.cdc.consumergradle.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MathController {

    @GetMapping("/calculate")
    public String checkOddAndEven(@RequestParam("number") Integer number) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                "http://localhost:8090/validate/prime-number?number=" + number,
                HttpMethod.GET,
                new HttpEntity<>(httpHeaders),
                String.class);

        return responseEntity.getBody();
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
