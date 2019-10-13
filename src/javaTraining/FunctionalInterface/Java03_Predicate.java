package javaTraining.FunctionalInterface;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Predicate
 *
 * 전달값을 받아서 Boolean 으로 리턴해주는 인터페이스
 * Function<T, boolean> 과 동일하게 볼 수 있다.
 *
 * @since 2019-10-12
 */
public class Java03_Predicate {

    public static void main(String[] args) {


        /** 1. 전달 Integer값이 양수인지 확인 */

        /** 1-1. 메서드로 풀어서 작성 */
        Predicate<Integer> predicate1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer value) {
                return value > 0;
            }
        };
        boolean result1 = predicate1.test(100);

        /** 1-2. 람다식 변환 */
        Predicate<Integer> predicate2 = value -> value > 0;
        boolean result2 = predicate2.test(100);


        /** 2, 예제 */
        List<Integer> list1 = Arrays.asList(-2,-1,0,1,2,3,4,5);
        Predicate<Integer> predicate3 = value -> value < 0;
        System.out.println( filter(list1, predicate3) );    // Predicate 인터페이스 선언하여 사용
        System.out.println(filter(list1, (i -> i < 0)));    // 직접 Predicate 실행코드 작성

        // 결과 : [-2, -1]

    }


    /**
     * List에서 Predicte 조건에 맞는 배열만 List에 담아 리턴해주는 메서드
     * @param list
     * @param isFilter
     * @param <T>
     * @return
     */

    private static <T> List<T> filter(List<T> list, Predicate<T> isFilter) {
        List<T> result = new ArrayList<>();
        for(T input : list){
            if(isFilter.test(input)){
                result.add(input);
            }
        }
        return result;
    }





}
