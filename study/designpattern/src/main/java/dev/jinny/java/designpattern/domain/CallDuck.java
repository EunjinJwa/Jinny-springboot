package dev.jinny.java.designpattern.domain;

import dev.jinny.java.designpattern.impl.Quack;
import dev.jinny.java.designpattern.service.QuackBehavior;

public class CallDuck {

    public QuackBehavior quackBehavior;

    public CallDuck() {
        quackBehavior = new Quack();
    }
}
