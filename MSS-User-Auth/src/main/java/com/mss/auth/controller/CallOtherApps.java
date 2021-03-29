package com.mss.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CallOtherApps {

    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/call-app-one")
    public String callAppOne(){
        return restTemplate.getForObject("http://localhost:8091/app-one", String.class);
    }
}
