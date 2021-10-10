package dev.jinny.java.study.general.training.javaEtc;

public class StringByte {

    public static void main(String[] args) {
        String a = "kassy 123456 kassy ";

        // byte 변환
        byte[] b = a.getBytes();

        // byte를 String으로 변환
        String str = new String(b);

    }

}
