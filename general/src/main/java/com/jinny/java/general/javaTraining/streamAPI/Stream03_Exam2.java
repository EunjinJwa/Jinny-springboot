package com.jinny.java.general.javaTraining.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream API 기초
 *
 * Intermediate Operation Method
 *      - 중간단계 메서드
 *      - Stream을 리턴하기 때문에 계속 Method Chainging을 통해 무엇을 해야할지 스트림에게 지시할 수 있음.
 * Terminal Operation Method
 *      - 끝내는 메서드
 *
 * @since 2019-10-13
 */
public class Stream03_Exam2 {
    public static void main(String[] args) {


        /** collect(toList())  */
        List resultList = Stream.of(1,2,3,4,5)
                                  .filter(i -> i > 3)   // integer
                                  .map(i -> i * 2)      // integer
                                  .map(i -> "#"+i )     // String   -- Inter ediate Operation Method 로, 아직 Stream이 최종 실행된 것이 아님.
                                  .collect(Collectors.toList());       // Terminal Operation Method인 collect 를 사용하여 Stream을 종료하고 List 형식으로 리턴함.

        System.out.println(resultList);

        /** distinct().collect(toList())  */
        List resultList2 = Stream.of(1,2,3,4,5)
                .filter(i -> i > 3)   // integer
                .map(i -> i * 2)      // integer
                .map(i -> "#"+i )     // String   -- Inter ediate Operation Method 로, 아직 Stream이 최종 실행된 것이 아님.
                .distinct()
                .collect(Collectors.toList());       // Terminal Operation Method인 collect 를 사용하여 Stream을 종료하고 List 형식으로 리턴함.
        System.out.println(resultList2);


        /** collect(toSet()) */
        // Set : 중복요소 제거. 순서보장 안됨.
        Set resultSet = Stream.of(1,3,3,5,5)
                .filter(i -> i > 3)   // integer
                .map(i -> i * 2)      // integer
                .map(i -> "#"+i )     // String   -- Inter ediate Operation Method 로, 아직 Stream이 최종 실행된 것이 아님.
                .collect(Collectors.toSet());       // Terminal Operation Method인 collect 를 사용하여 Stream을 종료하고 List 형식으로 리턴함.

        System.out.println(resultSet);



    }
}
