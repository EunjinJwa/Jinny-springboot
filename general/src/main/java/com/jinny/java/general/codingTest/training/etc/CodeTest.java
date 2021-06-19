package com.jinny.java.general.codingTest.training.etc;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kassy.
 * Date: 2019-12-07
 */
public class CodeTest {
    public static void main(String[] args) {
        System.out.println(isIsogram("abca"));
        System.out.println(isIsogram("agdrc"));
        System.out.println(isIsogram("ogeros"));
        System.out.println(isIsogram("OrangeoR"));
    }

    public static boolean  isIsogram(String str) {
        final int[] a = {0,0};

        str.toUpperCase().chars().forEach(c -> {
            if("X".equals(c)){
                a[0] = a[0]++;
            }else if("O".equals(c)){
                a[1] = a[1]++;
            }
        });

        str.toUpperCase().chars().filter(c -> "X".equals(c) || "O".equals(c)).count();

        return str.length() == str.toUpperCase().chars().distinct().count();
    }
}
