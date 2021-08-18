package dev.jinny.java.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class MathUtils {

    private static final BigDecimal TWO = BigDecimal.valueOf(2);

    public static BigDecimal getBigDecimal(Object value) {
        BigDecimal ret = null;

        if (value != null) {
            if (value instanceof BigDecimal) {
                ret = (BigDecimal) value;
            } else if (value instanceof String) {
                ret = new BigDecimal((String) value);
            } else if (value instanceof Integer) {
                ret = BigDecimal.valueOf((Integer) value);
            } else if (value instanceof BigInteger) {
                ret = new BigDecimal((BigInteger) value);
            } else if (value instanceof Long) {
                ret = BigDecimal.valueOf((Long) value);
            } else if (value instanceof Double) {
                ret = BigDecimal.valueOf((Double) value);
            } else if (value instanceof Number) {
                ret = BigDecimal.valueOf(((Number) value).doubleValue());
            } else {
                throw new ClassCastException("Not possible to coerce [" + value + "] from class " + value.getClass() + " into a BigDecimal.");
            }
        }

        return ret;
    }

    public static BigDecimal log(int base_int, BigDecimal x) {
        BigDecimal result = BigDecimal.ZERO;

        BigDecimal input = new BigDecimal(x.toString());
        int decimalPlaces = 100;
        int scale = input.precision() + decimalPlaces;

        int maxite = 10000;
        int ite = 0;
        BigDecimal maxError_BigDecimal = new BigDecimal(BigInteger.ONE,
                decimalPlaces + 1);
        // System.out.println("maxError_BigDecimal " + maxError_BigDecimal);
        // System.out.println("scale " + scale);

        RoundingMode a_RoundingMode = RoundingMode.UP;

        BigDecimal two_BigDecimal = new BigDecimal("2");
        BigDecimal base_BigDecimal = new BigDecimal(base_int);

        while (input.compareTo(base_BigDecimal) == 1) {
            result = result.add(BigDecimal.ONE);
            input = input.divide(base_BigDecimal, scale, a_RoundingMode);
        }

        BigDecimal fraction = new BigDecimal("0.5");
        input = input.multiply(input);
        BigDecimal resultplusfraction = result.add(fraction);
        while (((resultplusfraction).compareTo(result) == 1)
                && (input.compareTo(BigDecimal.ONE) == 1)) {
            if (input.compareTo(base_BigDecimal) == 1) {
                input = input
                        .divide(base_BigDecimal, scale, a_RoundingMode);
                result = result.add(fraction);
            }
            input = input.multiply(input);
            fraction = fraction.divide(two_BigDecimal, scale,
                    a_RoundingMode);
            resultplusfraction = result.add(fraction);
            if (fraction.abs().compareTo(maxError_BigDecimal) == -1) {
                break;
            }
            if (maxite == ite) {
                break;
            }
            ite++;
        }

        MathContext a_MathContext = new MathContext(
                ((decimalPlaces - 1) + (result.precision() - result.scale())),
                RoundingMode.HALF_UP);
        BigDecimal roundedResult = result.round(a_MathContext);
        BigDecimal strippedRoundedResult = roundedResult
                .stripTrailingZeros();
        //return result;
        //return result.round(a_MathContext);
        return strippedRoundedResult;
    }

    public static BigDecimal sqrt(BigDecimal number) {
        int digits; // final precision
        BigDecimal numberToBeSquareRooted;
        BigDecimal iteration1;
        BigDecimal iteration2;
        BigDecimal temp1 = null;
        BigDecimal temp2 = null; // temp values

        int extraPrecision = number.precision();
        MathContext mc = new MathContext(extraPrecision,
                RoundingMode.HALF_UP);
        numberToBeSquareRooted = number; // bd global variable
        double num = numberToBeSquareRooted.doubleValue(); // bd to double

        if (mc.getPrecision() == 0)
            throw new IllegalArgumentException(
                    "\nRoots need a MathContext precision > 0");
        if (num < 0.)
            throw new ArithmeticException(
                    "\nCannot calculate the square root of a negative number");
        if (num == 0.)
            return number.round(mc); // return sqrt(0) immediately

        if (mc.getPrecision() < 50) // small precision is buggy..
            extraPrecision += 10; // ..make more precise
        int startPrecision = 1; // default first precision

        /* create the initial values for the iteration procedure:
         * x0:  x ~ sqrt(d)
         * v0:  v = 1/(2*x)
         */
        if (num == Double.POSITIVE_INFINITY) // d > 1.7E308
        {
            BigInteger bi = numberToBeSquareRooted.unscaledValue();
            int biLen = bi.bitLength();
            int biSqrtLen = biLen / 2; // floors it too

            bi = bi.shiftRight(biSqrtLen); // bad guess sqrt(d)
            iteration1 = new BigDecimal(bi); // x ~ sqrt(d)

            MathContext mm = new MathContext(5, RoundingMode.HALF_DOWN); // minimal precision
            extraPrecision += 10; // make up for it later

            iteration2 = BigDecimal.ONE.divide(
                    BigDecimal.valueOf(2).multiply(iteration1, mm), mm); // v = 1/(2*x)
        } else // d < 1.7E10^308  (the usual numbers)
        {
            double s = Math.sqrt(num);
            iteration1 = new BigDecimal(s); // x = sqrt(d)
            iteration2 = new BigDecimal(1. / 2. / s); // v = 1/2/x
            // works because Double.MIN_VALUE * Double.MAX_VALUE ~ 9E-16, so: v > 0

            startPrecision = 64;
        }

        digits = mc.getPrecision() + extraPrecision; // global limit for procedure

        // create initial MathContext(precision, RoundingMode)
        MathContext n = new MathContext(startPrecision,
                mc.getRoundingMode());

        return sqrtProcedure(n, digits, numberToBeSquareRooted, iteration1,
                iteration2, temp1, temp2); // return square root using argument precision
    }

    private static BigDecimal sqrtProcedure(MathContext mc, int digits,
                                            BigDecimal numberToBeSquareRooted, BigDecimal iteration1,
                                            BigDecimal iteration2, BigDecimal temp1, BigDecimal temp2) {
        // next v                                         // g = 1 - 2*x*v
        temp1 = BigDecimal.ONE.subtract(TWO.multiply(iteration1, mc)
                .multiply(iteration2, mc), mc);
        iteration2 = iteration2.add(temp1.multiply(iteration2, mc), mc); // v += g*v        ~ 1/2/sqrt(d)

        // next x
        temp2 = numberToBeSquareRooted.subtract(
                iteration1.multiply(iteration1, mc), mc); // e = d - x^2
        iteration1 = iteration1.add(temp2.multiply(iteration2, mc), mc); // x += e*v        ~ sqrt(d)

        // increase precision
        int m = mc.getPrecision();
        if (m < 2)
            m++;
        else
            m = m * 2 - 1; // next Newton iteration supplies so many exact digits

        if (m < 2 * digits) // digits limit not yet reached?
        {
            mc = new MathContext(m, mc.getRoundingMode()); // apply new precision
            sqrtProcedure(mc, digits, numberToBeSquareRooted, iteration1,
                    iteration2, temp1, temp2); // next iteration
        }

        return iteration1; // returns the iterated square roots
    }

}
