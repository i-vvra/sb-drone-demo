package com.sb.drone.example.sbdronedemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    public HelloWorldController() {

    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }


}