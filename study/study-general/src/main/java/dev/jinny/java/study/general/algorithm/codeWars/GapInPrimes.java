package dev.jinny.java.study.general.algorithm.codeWars;

/**
 * Created by Kassy.
 * Date: 2020-01-01
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

/**
 * 정해진 범위 내의 숫자에서 n 만큼 갭이 있는 소수를 찾아라.
 * g,m,n
 * g (간격) (integer >= 2) which indicates the gap we are looking for
 * m (start number) (integer > 2) which gives the start of the search (m inclusive)
 * n (end number) (integer >= m) which gives the end of the search (n inclusive)
 * ex)
 *  GapInPrimes.gap(2,100,110) => {101, 103}
 *  GapInPrimes.gap(4,100,110) => {103, 107}
 */
public class GapInPrimes {
    public static void main(String[] args) {
        for(long a: GapInPrimes.gap_2(2, 1, 30000)) {
            System.out.println(a);
        };
    }

    /**
     * 시도 2
     * @param g
     * @param m
     * @param n
     * @return
     */
    public static long[] gap_2(int g, long m, long n) {
        long[] result = null;

        List<Long> primList = new ArrayList<Long>();
        primList.add((long) 2);
        for(long i = 2; i < primList.size(); i++) {
        }



        return result;
    }


    /**
     * 시도 1.
     * 결과는 정답이나, timeout이 남
     * GapInPrimes.gap(2, 10000000, 11000000) timeout.
     * @param g
     * @param m
     * @param n
     * @return
     */
    public static long[] gap_1(int g, long m, long n) {
        long[] result = null;

        System.out.println("Start : " + System.currentTimeMillis()/1000);
        /** m과 n 사이 숫자 중 소수만 추려서 배열에 담기 */
        long[] primeNums = LongStream.range(m+1, n+1)
                .filter(i -> i%2 != 0)
                .filter(i -> {
                    long c = 3;
                    while(c < i){
                        if (i%c == 0) return false;
                        else c = c+2;
                    }
                    return true;
                }
        ).toArray();

        System.out.println(System.currentTimeMillis()/1000);

        /** 소수 개수가 1개일 경우 1개를 result에 담아준다. */
        if(primeNums.length == 1) {
            result = new long[2];
            result[0] = primeNums[0];
            result[1] = primeNums[0];
        }
        /** 간격이 g 와 같은 첫 번째 숫자 조합을 result에 담아준다. */
        else {
            for(int i=0; i < primeNums.length; i++) {
                if(i+1 < primeNums.length) {
                    if((primeNums[i+1] - primeNums[i]) == g) {
                        result = new long[2];
                        result[0] = primeNums[i];
                        result[1] = primeNums[i+1];
                        break;
                    }
                }
            }
        }

        System.out.println(System.currentTimeMillis());

        return result;
    }
}
