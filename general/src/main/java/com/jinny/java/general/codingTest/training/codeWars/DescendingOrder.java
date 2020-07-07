package com.jinny.java.general.codingTest.training.codeWars;

/**
 * Created by Kassy.
 * Date: 2019-12-11
 */

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Your task is to make a function that can take any non-negative integer as a argument and return it with its digits in descending order.
 * Essentially, rearrange the digits to create the highest possible number.
 *
 * Examples:
 * Input: 21445 Output: 54421
 * Input: 145263 Output: 654321
 */
public class DescendingOrder {
    public static void main(String[] args) {
        System.out.println(sortDesc_others(938574));
    }

    public static int sortDesc(final int num) {

        Comparator comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };
        String[] strArr = String.valueOf(num).split("");
        Integer[] intArr = new Integer[strArr.length];
        for(int i = 0; i < strArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        Arrays.sort(intArr, comparator);

        StringBuilder resultStr = new StringBuilder();
        Arrays.stream(intArr).forEach(i -> {
            resultStr.append(String.valueOf(i));
        });
        return Integer.parseInt(resultStr.toString());
    }


    public static int sortDesc_others(final int num) {
        return Integer.parseInt(String.valueOf(num)
                .chars()
                .mapToObj(i -> String.valueOf(Character.getNumericValue(i)))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining()));
    }
}

