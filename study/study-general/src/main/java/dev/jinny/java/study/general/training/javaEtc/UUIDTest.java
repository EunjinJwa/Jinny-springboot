package dev.jinny.java.study.general.training.javaEtc;

import java.util.UUID;
import java.util.zip.CRC32;

public class UUIDTest {

    public static void main(String[] args) {
        genUUIDRandom();

        genUUID();
    }


    /**
     * 랜덤한 UUID 생성
     */
    public static void genUUIDRandom() {
        UUID random1 = UUID.randomUUID();
        System.out.println("UUID : " + random1.toString());

        System.out.println("--------------------------------------------------");
    }

    /**
     * CRC32를 사용하여 문자열 + 숫자 조합한 유의미한 UUID 생성
     */
    public static void genUUID() {
        String key = "kassy";
        CRC32 crc = new CRC32();
        crc.update(key.getBytes());

        String uuidString = new UUID(System.currentTimeMillis(),crc.getValue()).toString();
        System.out.println("UUID : " + uuidString);

        System.out.println("UUID : " + new UUID(100000, 200000).toString());

        System.out.println("--------------------------------------------------");

    }







}
