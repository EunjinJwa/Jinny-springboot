package dev.jinny.java.designpattern;

import dev.jinny.java.designpattern.domain.CallDuck;
import dev.jinny.java.designpattern.domain.Duck;
import dev.jinny.java.designpattern.domain.MallardDuck;
import dev.jinny.java.designpattern.domain.RubberDuck;
import dev.jinny.java.designpattern.impl.MuteQuack;

public class MiniDuckSimulator {

    public static void main(String[] args) {
        Duck mallard = new MallardDuck();

        mallard.display();
        mallard.performFly();
        mallard.performQuack();

        Duck rubberDuck = new RubberDuck();
        rubberDuck.display();
        rubberDuck.performFly();
        rubberDuck.performQuack();
        rubberDuck.setQuackBehavior(new MuteQuack());
        rubberDuck.performQuack();


        CallDuck callDuck = new CallDuck();
        callDuck.quackBehavior.quack();

    }

}
