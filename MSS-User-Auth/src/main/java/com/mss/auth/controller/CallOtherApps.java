package com.mss.auth.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.ws.rs.PathParam;

/*
    it will call the App-One by passing token in the header
     - Rajeev (rpothuraju@miraclesoft.com)
 */
@RestController
public class CallOtherApps {

    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/call-app-one")
    public ResponseEntity<String> callAppOne(@PathParam("token") String token) throws JsonProcessingException{
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + token);
        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8091/app-one", HttpMethod.GET, entity, String.class);
        return response;
    }
}
