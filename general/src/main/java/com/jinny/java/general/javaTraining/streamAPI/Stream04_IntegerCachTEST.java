package com.jinny.java.general.javaTraining.streamAPI;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Integer Cash 및 Integer Object간 비교구문 이해
 *----------------------------------------------------------
 * Equality : equals()를 이용해서 값 확인
 * Identity: == 을 이용해 메모리 레퍼런스 확인
 * ---------------------------------------------------------
 * Integer.IntegerCache() 참고
 *
 * @since 2019-10-13
 */
public class Stream04_IntegerCachTEST {
    public static void main(String[] args) {

        /**
         * Integer 는 -128 ~ 127 까지의 숫자는 메모리 Cash를 사용한다.
         * 즉, 새로운 Integer Object를 생성하지 않고, 같은 메모리 레퍼런스 주소값을 가진다.
         * 따라서 서로 다른 객체더라도 identity 비교가 가능하다. (== 비교)
         */

        List<Integer> intList = Arrays.asList(1,2,3,4,5,127,128,150);
        final Integer findInt127 = 127;
        final Integer findInt150 = 150;

        /**
         * 127
         * == 비교
         * 127은 Integer Cash 범위 내에 속하므로, Integer Object를 새로 생성하지 않고 Cash를 사용한다.
         * 레퍼런스 주소값이 같으므로 == 비교가 가능하다.
         */
        System.out.println(
                intList.stream()
                        .filter(i -> i == findInt127)
                        .collect(toList())
        ); // 결과 : [127]

        /**
         * 150
         * == 비교
         * 150은 Cash 범위를 벗어나므로, Integer Object 를 새로 생성한다. => 두 Object의 레퍼런스 주소값이 서로 다름.
         * 따라서 메모리 레퍼런스 비교를 하면 같지 않다는 결과가 나온다.
         */
        System.out.println(
                intList.stream()
                        .filter(i -> i == findInt150)
                        .collect(toList())
        ); // 결과 : [] . List의 150과 findInt150은 서로 다른 주소값을 가짐. 따라서 같지 않으므로 empty 를 리턴.

        /**
         * 150
         * equals() 비교
         * 주소값이 서로 다른 Obejct의 값 비교는 equals()를 사용하면 된다.
         */
        System.out.println(
                intList.stream()
                       .filter(i -> i.equals(findInt150))
                        .collect(toList())
        ); // 결과 : [150]



        /** Integer Object간 identity 비교  ================================================================================ */

        /**  Integer 3 */
        Integer a = 3;
        Integer b = 3;
        System.out.println(a == b);     // true

        /** Integer 180 */
        Integer c = 180;
        Integer d = 180;
        System.out.println(c == d);     // false

        /** int 180  - int 는 Object가 아니므로 비교 가능*/
        int int1 = 180;
        int int2 = 180;
        System.out.println(int1 == int2);   // true


    }

}
