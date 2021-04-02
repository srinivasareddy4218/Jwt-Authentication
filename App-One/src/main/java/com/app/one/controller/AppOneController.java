package com.app.one.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppOneController {

    @GetMapping("/app-one")
    public String appOne(){
        return "Welcome from App One";
    }
}
