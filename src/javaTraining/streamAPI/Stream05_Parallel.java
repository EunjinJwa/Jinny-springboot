package javaTraining.streamAPI;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Stream API - Parallel Programming
 * Stream을 이용한 병렬 프로그래밍
 *
 * @since 2019-10-12
 *
 * Stream 처리를 할때 병렬로 나누어 stream을 진행할 수 있도록 한다. (병렬 => Core 를 여러개로 나누어 진행)
 * 진행되는 순서는 보장되지 않는다.
 */
public class Stream05_Parallel {

    public static void main(String[] args) {

        /** 1-1. Single Core Processor */
        final int[] sum = {0};
        IntStream.range(1,100)
                 .forEach(i -> sum[0] += i);
        System.out.println("SingleCore Sum : " + sum[0]);

        /** 1-2. Parallel Processor - with side-effect*/
        final int[] sum2 = {0};
        IntStream.range(1,100)
                .parallel()
                .forEach(i -> sum2[0] += i);
        System.out.println("Parallel Sum (side-effect) : " + sum2[0]);

        /** 1-3. Single Core Processor - sum() 함수 사용*/
        int sumInt = 0;
        sumInt = IntStream.range(1,100)
                .sum();
        System.out.println("SingleCore Sum() : " + sumInt);

        /** 1-4. Parallel Processor - sum() 함수 사용*/
        int sumInt2 = 0;
        sumInt2 = IntStream.range(1,100)
                .parallel()
                .sum();
        System.out.println("Parallel Sum() : " + sumInt2);





        /** ArrayList Parallel Test
         * 처리시간 확인을 위해  스레드별 Sleep 1초를 설정한다.
         * */

        /** 2-1. Single Core Stream 의 처리시간 확인 */
        final long startTime1 = System.currentTimeMillis();
        Arrays.asList(1,2,3,4,5,6,7,8)
                .stream()
                .map(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i;
                })
                .forEach(i -> System.out.println(i));
        System.out.println(System.currentTimeMillis() - startTime1);    // 배열 항목마다 각 1초씩 총 8초 소요

        /** 2-2. parallelStream 의 처리시간 확인 */
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "0");
            // System의 Parallelism을 설정을 통해 Core  수를 정의할 수 있다.
            // 근데 내 컴에서는 안먹는 듯 함. core 수와 상관없이 2초가 소요됨.
        final long startTime2 = System.currentTimeMillis();
        Arrays.asList(1,2,3,4,5,6,7,8)
                .parallelStream()
                .map(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i;
                })
                .forEach(i -> System.out.println(i));       // Parallel을 사용하면 사용되는 배열의 순서는 보장되지 않는다.
        System.out.println(System.currentTimeMillis() - startTime2);    // Parallel 이 동작하여 총 2초 소요








    }


}
