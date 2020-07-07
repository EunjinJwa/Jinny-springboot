package com.jinny.java.springboot.multidb.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TestService {


    @Async
    public void asyncTest(String name) throws Exception{
        for (int i = 0; i < 10; i++) {
            System.out.println(name + " : " + i);
            Thread.sleep(1000);
        }
    }

}
