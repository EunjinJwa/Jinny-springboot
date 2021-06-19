package com.jinny.java.springboot.lottery.common;

import java.util.Arrays;
import java.util.List;

public class Constants {

    public enum LOTTO_AUTHORITY_KEY {
        ADMIN,
        DHKIM,
        CUSTOM;

        public static List<LOTTO_AUTHORITY_KEY> getAsList() {
            return Arrays.asList(values());
        }
    }

    public static String convertListToString(List<Integer> list) {
        StringBuffer sb = new StringBuffer();
        for (Integer number : list) {
            sb.append(number).append(", ");
        }
        String result = sb.toString();
        return result.substring(0, result.length()-2);
    }





}
