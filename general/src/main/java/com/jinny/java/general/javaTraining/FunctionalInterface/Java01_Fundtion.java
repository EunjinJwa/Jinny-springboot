package com.jinny.java.general.javaTraining.FunctionalInterface;

import java.util.function.Function;

/**
 * Function
 *
 * @since 2019-10-12
 */
public class Java01_Fundtion {

    public static void main(String[] args) {


        /** 1. String 을 Integer 로 변환하는 Function*
         *
         * String -> Integer
         */

        /** 1-1. 메서드로 풀어서 작성 */
        Function<String, Integer> toInt = new Function<String, Integer>() {
            @Override
            public Integer apply(String value) {
                return Integer.parseInt(value);
            }
        };
        Integer resultNum = toInt.apply("10");
        System.out.println(resultNum);

        /** 1-2. Lamda Expression 변형 */
        Function<String, Integer> toInt2 =  (str -> Integer.parseInt(str));
        Integer resultNum2 = toInt2.apply("10");
        System.out.println(resultNum2);



        /** 2. Identity Function
         *
         * Identity function 은 전달값과 리턴값의 타입이 동일하고 값 또한 동일하다.
         * 전달받은 값을 그대로 전달.
         * T -> T
         * */

        /** 2-1. identity() 함수 사용*/
        final Function<Integer, Integer> identityFn = Function.identity();
        Integer resultNum3 = identityFn.apply(900);
        System.out.println(resultNum3);

        /** 람다식 변환
         *
         * 값이 그대로 리턴되도록 함수내용을 직접 코딩.
         * */
        final Function<Integer, Integer> identityFn2 = (t -> t);
        System.out.println(identityFn2.apply(900));



    }
}
