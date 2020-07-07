package com.jinny.java.springboot.multidb.controller;

import com.jinny.java.springboot.multidb.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService testService;

    @GetMapping(path="/async/{name}", produces = "application/json")
    public ResponseEntity<Object> asyncTest(@PathVariable("name") String name) {
        try{
            testService.asyncTest(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


}
