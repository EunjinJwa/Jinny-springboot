package com.jinny.java.springboot.singledb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(path="/test/long-process")
    public ResponseEntity<Object> pause() throws InterruptedException {
        System.out.println("/test/long-process 실행 ");
        Thread.sleep(10000);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping(path="/test/exception")
    public ResponseEntity<Object> exceptionTest() {

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
