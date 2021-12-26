package dev.jinny.java.designpattern.domain;

import dev.jinny.java.designpattern.impl.FlyNoWay;
import dev.jinny.java.designpattern.impl.Squeak;

public class RubberDuck extends Duck {
    @Override
    public void display() {
        System.out.println("저는 러버덕(고무오리) 입니다. ");
    }

    public RubberDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Squeak();
    }
}
