package com.jinny.java.springboot.multidb.proxy;

public class Store {


    Payment payment;

    // Dependency Injection
    public Store(Payment payment) {
        this.payment = payment;
    }

    public void buySomthing(int amount) {
        payment.pay(amount);
    }
}
