package dev.jinny.java.designpattern.impl;

import dev.jinny.java.designpattern.service.QuackBehavior;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("꽥꽥!!");
    }
}
