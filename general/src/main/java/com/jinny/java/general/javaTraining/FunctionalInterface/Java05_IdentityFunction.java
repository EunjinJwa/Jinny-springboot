package com.jinny.java.general.javaTraining.FunctionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

/**
 * Identity Function 활용
 */
public class Java05_IdentityFunction {
    public static void main(String[] args) {

        List<Integer> numList = Arrays.asList(1,2,3,4,5);

        /** 예시
         * 위 리스트에 대하여, 특정 함수를 적용한 결과값을 리턴하도록 한다.
         * 함수가 null 인경우, numList 요소를 그대로 반환한다.
         * */

        //1.
        List<Integer> resultList1 = getList1(numList, i -> i*2);

        //2.
        List<Integer> resultList2 = getList2(numList, i -> i*2);

        // 3. mapper 전달값에 null을 전달하지 않고, identity function 을 전달.
        List<Integer> resultList3 = getList3(numList, i -> i*2);
        List<Integer> resultList4 = getList3(numList, i -> i);          // identity
        List<Integer> resultList5 = getList3(numList, Function.identity());     // identity

    }

    /** 1. Bad Case
     * 결과는 정상이지만 코딩이 길어지고 알아보기 힘듬
     * */
    private static <T, R> List<R> getList1(List<T> list, Function<T, R> mapper){
        List<R> resultList;

        if(mapper == null){
            resultList = (List<R>) list;
        }else{
            resultList = new ArrayList<>();
            for(T t : list){
                resultList.add(mapper.apply(t));
            }
        }
        return resultList;
    }

    /**
     * 2. Identity Function 사용
     */
    private static <T, R> List<R> getList2(List<T> list, Function<T, R> mapper){
        final List<R> resultList = new ArrayList<>();

        // Function 이 null인경우, 아닌경우에 대한 Function 재정의
        final Function<T, R> function;
        if(mapper == null){
            function = t -> (R) t;      // identity Function  >> (T -> R) 이므로 형변환 필요,
        }else{
            function = mapper;
        }

        for(T t: list){
            resultList.add(mapper.apply(t));
        }
        return resultList;
    }


    /**
     * 3. Identity Function
     * 제일 간결한 방법. getList 메서드에서 mapper 가 null인지 체크를 할 필요가 없음.
     *
     * 호출부에서 null 일때 identity Function 전달하여 사용하는 방법.
     */
    private static <T, R> List<R> getList3(List<T> list, Function<T, R> mapper){
        List<R> resultList = new ArrayList<>();
        for(T t: list){
            resultList.add(mapper.apply(t));
        }
        return resultList;
    }


}
