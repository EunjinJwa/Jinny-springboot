package com.jinny.java.springboot.singledb;

import com.jinny.java.springboot.singledb.config.ContextBean;
import com.jinny.java.springboot.singledb.model.AuthToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//
//@Component
//public class BatchRunner implements ApplicationRunner {
//
//    @Autowired
//    ContextBean contextBean;
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        contextBean.createTocken();
//        System.out.println("BatchRunner > " + contextBean.getToken().getAccessToken());
//    }
//}
