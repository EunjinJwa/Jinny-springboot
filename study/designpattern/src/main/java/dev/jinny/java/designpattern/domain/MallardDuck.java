package dev.jinny.java.designpattern.domain;

import dev.jinny.java.designpattern.impl.FlyWithWings;
import dev.jinny.java.designpattern.impl.Quack;

/**
 * 청둥오리 class
 */
public class MallardDuck extends Duck {
    @Override
    public void display() {
        System.out.println("MallardDuck 만의 외모를 지정합니다. ");
    }

    // 오리의 행동 형식을 생성자에서 인스턴스를 만드는 방법
    public MallardDuck() {
        flyBehavior = new FlyWithWings();       // Duck의 공통 속성인 나는것의 구현체를 직접 지정해줌.
        quackBehavior = new Quack();            // Duck의 공통 속성인 울음의 구현체를 직접 지정해줌.
    }


}
