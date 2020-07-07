package com.jinny.java.general.javaTraining.FunctionalInterface;

import java.util.function.Consumer;

/**
 * Consumer
 *
 * 받은 값에 대해 소비하고 리턴값이 없는 void 인터페이스
 *
 * @since 2019-10-12
 */
public class Java02_Consumer {
    public static void main(String[] args) {

        /** 1. 전달값을 출력하는 consumer 작성 */

        /** 1-1. 메서드로 풀어서 작성 */
        final Consumer<String> consum1 = new Consumer<String>() {
            @Override
            public void accept(String value) {
                System.out.println(value);
            }
        };
        consum1.accept("Hello");

        /** 1-2 . 람다식 변환*/
        final Consumer<String> consum2 = (value -> System.out.println(value));
        consum2.accept("Hello");


        /** 예제 */
        final Consumer<String> consum3 = name -> System.out.println("Hello " + name);
        consum3.accept("kassy");







    }
}
