package com.jinny.java.springboot.multidb.proxy;

import org.junit.rules.Stopwatch;
import org.springframework.util.StopWatch;

public class PayProxy implements Payment{

    Payment cash = new Cash();

    @Override
    public void pay(int amount) {
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();

        cash.pay(amount);

        stopwatch.stop();
        System.out.println(stopwatch.prettyPrint());

    }
}
