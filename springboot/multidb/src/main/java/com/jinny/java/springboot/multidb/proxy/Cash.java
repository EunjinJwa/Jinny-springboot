package com.jinny.java.springboot.multidb.proxy;

public class Cash implements Payment{

    @Override
    public void pay(int amount) {
        System.out.println("현금 결제 : " + amount);
    }
}
