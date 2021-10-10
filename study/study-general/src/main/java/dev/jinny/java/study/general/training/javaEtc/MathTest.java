package dev.jinny.java.study.general.training.javaEtc;


public class MathTest {




    public static void main(String[] args) {

        // 소숫점 n번째 반올림
//        mathFunction();

    }



    /**
     * Math 객체를 사용한 소숫점 처리
     */
    public static void mathFunction() {

        double doubleValue01 = 0.5478234;

        // 소수점 2째자리
        double result1 = Math.ceil((double)doubleValue01 * 10000)/100.0;
        double result2 = Math.round(doubleValue01*100)/100.0;

        System.out.println(result1);
        System.out.println(result2);

    }

}
