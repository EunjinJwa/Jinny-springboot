package dev.jinny.java.study.general.training.javaEtc;

import dev.jinny.java.utils.MathUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Date;

public class JavacodeTest {




    public static void main(String[] args) {

        // 소숫점 n번째 반올림
//        mathFunction();

        calculation1();
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

    public static void calculation1() {
        BigDecimal value = BigDecimal.ZERO;
        BigDecimal entrants = MathUtils.getBigDecimal(68);
        BigDecimal buyIn = MathUtils.getBigDecimal(4.6);
        BigDecimal buyInCount = MathUtils.getBigDecimal(1);
        BigDecimal entranceFee = MathUtils.getBigDecimal(0.4);
        BigDecimal rank = MathUtils.getBigDecimal(66);

        value = MathUtils.sqrt(
                        entrants
                                .divide(
                                        rank,
                                        MathContext.DECIMAL128
                                )
                )
                .multiply(
                        MathUtils.log(10,
                                entrants
                                        .multiply(
                                                buyIn.subtract(entranceFee)
                                                ,MathContext.DECIMAL128
                                        )
                        )
                        ,MathContext.DECIMAL128
                );

        System.out.println(value);
    }

}
