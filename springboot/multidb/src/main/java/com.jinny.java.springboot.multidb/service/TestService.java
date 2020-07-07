package com.jinny.java.springboot.multidb.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TestService {


    @Async
    public void asyncTest(String name) throws Exception{
        System.out.println(name);
        Thread.sleep(1000);
    }

}
