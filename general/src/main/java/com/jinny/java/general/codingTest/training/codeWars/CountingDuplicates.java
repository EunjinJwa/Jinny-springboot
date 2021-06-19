package com.jinny.java.general.codingTest.training.codeWars;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Created by Kassy.
 * Date: 2019-12-08
 */

/**
 * 문자열 내에 중복되는 문자의 개수 구하기 (대소문자 구문 안함)
 * Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric digits that occur more than once in the input string. The input string can be assumed to contain only alphabets (both uppercase and lowercase) and numeric digits.
 */
public class CountingDuplicates {

    public static void main(String[] args) {

    }

    public static int duplicateCount_eunjin(String text) {
        int dupleCnt = 0;
        List<String> numList = new ArrayList();
        text.toLowerCase().chars().distinct().forEach(i -> numList.add(String.valueOf((char)i)));
        for(String str : numList) {
            int exist = 0;
            for (int i = 0; i < text.length(); i++) {
                if (str.equals(String.valueOf(text.toLowerCase().charAt(i)))) {
                    exist++;
                    if (exist > 1) {
                        dupleCnt++;
                        break;
                    }
                }
            }
        }
        return dupleCnt;
    }

    static int duplicateCount(final String text) {
        return (int) charFrequenciesMap(text).values().stream()
                .filter(i -> i > 1)
                .count();
    }

    private static Map<Character, Long> charFrequenciesMap(final String text) {
        return text.toLowerCase().codePoints()
                .mapToObj(c -> (char) c)
                .collect(groupingBy(identity(), counting()));
    }


}
