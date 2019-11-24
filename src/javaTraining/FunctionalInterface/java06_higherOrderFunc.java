package javaTraining.FunctionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Higher order Function
 *
 * 메서드 파라메터 또는 결과로 Function 을 받는 Function
 *
 * Created by Kassy.
 * Date: 2019-11-24
 */
public class java06_higherOrderFunc {

    public static void main(String[] args) {

        /**
         * 메서드 전달자로 Function 이 오는 higher-order function
         */
        final Function<Function<Integer, String>, String> f = g -> g.apply(10);
        System.out.println(
                f.apply(i -> "#" + i)      // "#10"
        );


        /**
         * function 결과로 Function 을 리턴하는 higher-order function
         */
        final Function<Integer, Function<Integer, Integer>> f2 = i -> i2 -> i + i2;
        System.out.println(
                f2.apply(10).apply(9)
        );

        /** [예시 1]
         * map 이라는 메서드의 전달자로 function 을 전달한다.
         */
        List list = Arrays.asList(1,2,3,4,5);
        List mappedList = map(list, i -> "#" + i);
        System.out.println(
                mappedList
        );

        /** [예시 2] */
        System.out.println(
            list.stream()
                    .map(i -> "#" + i)  // 전달값이 function 인 메서드 map() 메서드
                    .collect(Collectors.toList())
        );

        /**
         * [예시 3]
         */
        Function<Integer, Function<Integer, Function<Integer, Integer>>> f3 =
                i1 -> i2 -> i3 -> i1 + i2 + i3;     // 커링 (?) 이라고 함.
        // 3-1
        System.out.println(
                f3.apply(1).apply(3).apply(5)
        );
        // 3-2
        // f3.apply(10) = 10 -> { i2 -> i3 -> 10 + i2 + i3 }
        final Function<Integer, Function<Integer, Integer>> plus10 = f3.apply(10);
        System.out.println(
                plus10.apply(2)     // 2 -> {i3 -> 10 + 2 + i3}  return 은 function
                      .apply(4)   // 4 -> {10 + 2 + 4}        return 은 integer
        );







    }

    /**
     * [예시 1]
     *
     */
    private static <T, R> List<R> map (List<T> list, Function<T, R> mapper) {
        final java.util.List<R> result = new ArrayList();
        for(final T t: list) {
            result.add(mapper.apply(t));
        }
        return result;
    }





}
