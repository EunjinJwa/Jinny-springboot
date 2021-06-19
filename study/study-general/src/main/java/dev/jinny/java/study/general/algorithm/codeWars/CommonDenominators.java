package dev.jinny.java.study.general.algorithm.codeWars;

/**
 * Created by Kassy.
 * Date: 2019-12-30
 */
public class CommonDenominators {
    public static void main(String[] args) {
        long[][] lst;
        // lst = new long[][] { {1, 2}, {1, 3}, {10, 40} };
        // lst = new long[][] { {3, 1}};
        lst = new long[][] {};

        /** 원래 리스트의 원소들을 소인수(?)로 다시 세팅 */
        long[][] new_lst = new long[lst.length][2];
        for(int i = 0; i < lst.length; i++) {
            long[] arr = lst[i];
            long maxDiv = cal_maxDiv(arr[0], arr[1]);
            new_lst[i][0] = arr[0]/maxDiv;
            new_lst[i][1] = arr[1]/maxDiv;

        }

        System.out.println( convertFrac(new_lst) );
    }

    public static String convertFrac(long[][] lst) {
        StringBuffer resultStr = new StringBuffer();
        if(lst.length > 0) {
            long minMultiple = lst[0][1];
            if(lst.length > 1) {
                for (int i = 0; i + 1 < lst.length; i++) {

                    if (i == 0) minMultiple = lst[i][1];
                    minMultiple = cal_minMultiple(minMultiple, lst[i + 1][1]);
                }
            }
            for(int i = 0; i < lst.length; i++) {
                long[] nums = lst[i];
                long mok = minMultiple/nums[1];
                resultStr.append("(" + (nums[0] * mok) + "," + minMultiple + ")" );
            }
        }
        return resultStr.toString();

    }

    /**
     * 최대공약수 - 유클리드호제법
     * @param num1
     * @param num2
     * @return
     */
    private static long cal_maxDiv(long num1, long num2){
        int result = 0;

        long bnum = (num1 >= num2) ? num1 : num2;
        long snum = (num1 >= num2) ? num2 : num1;
        long nam = bnum;

        do{
            nam = bnum % snum;
            bnum = snum;
            snum = nam;
        } while(nam > 0);

        return bnum;
    }

    /**
     * 최소공배수
     * 공식 = (num1 * num2) / 최대공약수
     * @param num1
     * @param num2
     * @return
     */
    private static long cal_minMultiple(long num1, long num2) {
        System.out.println(num1 + " , " + num2);
        System.out.println("최대공약수 : " + cal_maxDiv(num1, num2) );
        System.out.println("최소공배수 : " + (num1*num2)/cal_maxDiv(num1, num2) );
        return (num1*num2)/cal_maxDiv(num1, num2);
    }






}
