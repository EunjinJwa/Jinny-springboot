package com.jinny.java.springboot.singledb.service;

import com.jinny.java.springboot.singledb.config.ContextBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
    ContextBean contextBean;


    public void singletonTest() {
        //contextBean.createTocken2();
        System.out.println("batchTest 실행 : " + contextBean.getToken().getAccessToken());
    }
}
