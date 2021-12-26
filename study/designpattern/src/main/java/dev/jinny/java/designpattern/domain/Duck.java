package dev.jinny.java.designpattern.domain;

import dev.jinny.java.designpattern.service.FlyBehavior;
import dev.jinny.java.designpattern.service.QuackBehavior;

public abstract class Duck {

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck() {
    }

    // 상속 받은 곳에서 각자 알아서 구현하므로 추상메서드
    public abstract void display();

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void swim() {
        System.out.println("오리는 물에 뜹니다. 가짜 오리도 물에 뜨죠.! 공통입니다. ");
    }

}
