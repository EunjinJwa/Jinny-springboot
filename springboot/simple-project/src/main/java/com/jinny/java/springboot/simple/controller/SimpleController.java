package com.jinny.java.springboot.simple.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @GetMapping(value = "/test")
    public String testCall() {
        return "OK";
    }

}
