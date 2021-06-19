package dev.jinny.java.study.general.algorithm.codeWars;

/**
 * Created by Kassy.
 * Date: 2019-12-30
 */
public class CommonDenominators_other {
    public static void main(String[] args) {

        long[][] lst;
        lst = new long[][] { {1, 2}, {1, 3}, {10, 40} };
        // lst = new long[][] { {3, 1}};
        // lst = new long[][] {};

        System.out.println(convertFrac(lst));
    }

    public static String convertFrac(long[][] lst){
        /** 원래 리스트의 원소들을 소인수(?)로 다시 세팅 */
        long[][] new_lst = new long[lst.length][2];
        for(int i = 0; i < lst.length; i++) {
            long maxDiv = gcd(lst[i][0], lst[i][1]);
            new_lst[i][0] = lst[i][0]/maxDiv;
            new_lst[i][1] = lst[i][1]/maxDiv;
        }

        /** 배열의 모든 분모값의 최소공배수 구하기 */
        long lcmVal = 1;
        for(long[] nums : new_lst) {
            lcmVal = lcm(lcmVal, nums[1]);
        }

        StringBuffer result = new StringBuffer();
        for(long[] item : new_lst) {
            long multipleVal = lcmVal/item[1];
            result.append("(" + item[0]*lcmVal/item[1] + "," + lcmVal + ")");
        }

        return result.toString();
    }

    /**
     * 최대공약수
     * a, b는 음수가 아닌 정수
     * @param a
     * @param b
     * @return
     */
    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    /**
     * 최소공배수
     * @param a
     * @param b
     * @return
     */
    static long lcm(long a, long b) {
        return (a * b)/gcd(a,b);
    }
}
