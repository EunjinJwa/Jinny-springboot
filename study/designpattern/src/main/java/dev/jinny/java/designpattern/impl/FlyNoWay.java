package dev.jinny.java.designpattern.impl;

import dev.jinny.java.designpattern.service.FlyBehavior;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("저는 못 날아요.");
    }
}
