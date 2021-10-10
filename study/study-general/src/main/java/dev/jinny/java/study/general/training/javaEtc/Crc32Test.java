package dev.jinny.java.study.general.training.javaEtc;

import java.util.zip.CRC32;

public class Crc32Test {

    static CRC32 crc = new CRC32();

    public static void main(String[] args) {
        convertCrc("kassy");
        convertCrc(15L);
    }


    public static void convertCrc(String key) {
        byte[] bytes = key.getBytes();
        crc.update(bytes);
        long crcValue = crc.getValue(); // 10자리 long타입 숫자
        System.out.println("crc value = " + crcValue);


        // hexString 변환방법
        // 1. Long 변환 메서드 사용
        String result = Long.toHexString(crcValue);     // 16진수 문자열로 변환
        System.out.println("1. toHexString = " + result);         // 8자리 변환값

        // 2. String format 사용
        String result2 = String.format("%08x", crcValue);
        System.out.println("2. stringFormat 08x = " + result2);
        System.out.println("-------------------------------------------------");

    }

    public static void convertCrc(Long key) {
        String keyString = String.valueOf(key);
        byte[] bytes = keyString.getBytes();
        crc.update(bytes);
        long crcValue = crc.getValue(); // 10자리 long타입 숫자
        System.out.println("crc value = " + crcValue);


        // hexString 변환방법
        // 1. Long 변환 메서드 사용
        String result = Long.toHexString(crcValue);     // 16진수 문자열로 변환
        System.out.println("1. toHexString = " + result);         // 8자리 변환값

        // 2. String format 사용
        String result2 = String.format("%08x", crcValue);
        System.out.println("2. stringFormat 08x = " + result2);
        System.out.println("-------------------------------------------------");


    }


}
