package dev.jinny.java.study.general.algorithm.codeWars;

/**
 * Created by Kassy.
 * Date: 2019-12-12
 */

import java.util.Arrays;

/**
 * Given an array, find the integer that appears an odd number of times.
 * There will always be only one integer that appears an odd number of times.
 */
public class FindTheOddInt {
    public static void main(String[] args) {

        int[] arr = {1,1,2,-2,5,2,4,4,-1,-2,5};
        System.out.println(findIt(arr));
    }


    public static int findIt(int[] a) {
        int odd = 0;
        int[] b = new int[a.length];
        int cnt = 0;
        for(int k = 0; k < b.length; k++) {
            b[k] = a[k];
            for(int i = 0; i < a.length; i++) {
                if(b[k] == a[i]) {
                    cnt++;
                }
            }
            if(cnt%2 > 0) {
                odd = b[k];
                break;
            }
        }

        return odd;
    }

    public static int findIt_others(int[] a) {

        /**
         * 배열의 값을 ^(xor) 연산을 함
         *
         * 같은 수 끼리의 ^ 연산은 0 이 나오므로, 결국 홀수로 존재하는 하나의 수만 남을 수 밖에 없다.
          */

        return Arrays.stream(a).reduce(0, (x, y) -> x ^ y);
    }

}
