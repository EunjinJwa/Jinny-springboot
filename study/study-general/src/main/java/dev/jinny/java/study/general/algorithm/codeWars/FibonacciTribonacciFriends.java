package dev.jinny.java.study.general.algorithm.codeWars;

/**
 * Created by Kassy.
 * Date: 2019-12-30
 *
 * Fibonacci, Tribonacci and friends
 */

import java.util.Arrays;

/**
 * You have to build a Xbonacci function that takes a signature of X elements
 * - and remember each next element is the sum of the last X elements - and returns the first n elements of the so seeded sequence.
 *
 * xbonacci {1,1,1,1} 10 = {1,1,1,1,4,7,13,25,49,94}
 * xbonacci {0,0,0,0,1} 10 = {0,0,0,0,1,1,2,4,8,16}
 * xbonacci {1,0,0,0,0,0,1} 10 = {1,0,0,0,0,0,1,2,3,6}
 * xbonacci {1,1} produces the Fibonacci sequence
 */
public class FibonacciTribonacciFriends {
    public static void main(String[] args) {
        Arrays.stream(xbonacci_others(new double[]{ 1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,8.0,9.0},9)).forEach(
                d -> System.out.println(d)
        );
    }

    public static double[] xbonacci(double[] signature, int n) {
        double[] result = new double[n];
        int range = (signature.length < n) ? signature.length : n;
        for(int i = 0; i < range; i++) {
            result[i] = signature[i];
        }

        int fromIdx = 0;
        int toIdx = fromIdx + signature.length;

        while(toIdx < n) {
            double sumValue = 0;
            for (int i = fromIdx; i < toIdx; i++) {
                sumValue += result[i];
            }
            result[toIdx] = sumValue;
            fromIdx++;
            toIdx++;
        }
        return result;
    }

    /**
     * Arrays.copyOf() 로 배열 복사하여 new 배열 생성
     *
     * @param signature
     * @param n
     * @return
     */
    public static double[] xbonacci_others(double[] signature, int n) {
        double[] xbonacci = Arrays.copyOf(signature, n);

        for(int i = signature.length; i < n; i++) {
            for(int k = i; k >= (i - signature.length); k--) {
                xbonacci[i] += xbonacci[k];
            }
        }
        return xbonacci;
    }

}
