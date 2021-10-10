package dev.jinny.java.study.general.training.javaEtc;

public class NumeralSystem {

    /**
     * 2진법, 8진법, 10진법, 16진법
     */

    public static void main(String[] args) {

        binary();
        octal();
        hex();

        System.out.println("----------------------------");
        decimal();
    }

    /**
     * 2진법 변환
     */
    public static void binary() {

        Integer number = 74;

        // convert decimal to binary
        String binaryString = Integer.toBinaryString(number);
        System.out.println("2진수 : " + binaryString);

        // 10진수 변환
        Integer original = Integer.parseInt(binaryString, 2);
        System.out.println("원래 숫자 : " + original);

    }

    /**
     * 8진법 변환
     */
    public static void octal() {

        Integer number = 26;

        // convert decimal to binary
        String OctalString = Integer.toOctalString(number);
        System.out.println("8진수 : " + OctalString);
    }


    /**
     * 16진법 변환
     * 16진수는 0x 로 표기한다.
     */
    public static void hex() {

        // 16진수 참고
        // 10: a, 11: b, 12: c, ... 15: f, 16: 10, 17: 11, ..., 26: 1a

        Integer number = 26;

        // convert decimal to binary
        String hexString = Integer.toHexString(number);
        System.out.println("16진수 : " + hexString);


        System.out.println(String.format("%08x", number)); // 0x : 16진수로 변환, 8: 8자리 표현



    }

    /**
     * 10진법 변환
     *
     */
    public static void decimal() {
        String binaryString = "0000001";
        String octalString = "32";
        String hexString = "4a";

        Integer binary = Integer.parseInt(binaryString, 2);
        Integer octal = Integer.parseInt(octalString, 8);
        Integer hex = Integer.parseInt(hexString, 16);

        System.out.println("10진수 번환 (2진수) : " + binaryString + " -> " + binary);
        System.out.println("10진수 번환 (8진수) : " + octalString + " -> " + octal);
        System.out.println("10진수 번환 (16진수) : " + hexString + " -> " + hex);
    }










}
