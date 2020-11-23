package com.jinny.java.springboot.singledb.scheduler;

import com.jinny.java.springboot.singledb.config.ContextBean;
import com.jinny.java.springboot.singledb.model.AuthToken;
import com.jinny.java.springboot.singledb.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;

@Component
public class ScheduledTasks {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    ContextBean contextBean;

    @Autowired
    private TestService testService;

    private AuthToken authToken;

    @Scheduled(fixedDelay = 5000)
    public void batchFishBuffets() throws InterruptedException {
        if(contextBean.getToken() == null) {
            contextBean.createTocken();
        }
        authToken = contextBean.getToken();
        System.out.println("scheduler 실행 : " + authToken.getAccessToken());
        Thread.sleep(10000);
        System.out.println("scheduler 종료 ");
    }

//    @Scheduled(fixedDelay = 8000)
    public void batchTest() {

        testService.singletonTest();

    }




}
