package dev.jinny.java.designpattern.impl;

import dev.jinny.java.designpattern.service.FlyBehavior;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("날고있습니다.!!! ");
    }
}
