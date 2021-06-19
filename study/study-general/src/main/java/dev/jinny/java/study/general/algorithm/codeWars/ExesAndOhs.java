package dev.jinny.java.study.general.algorithm.codeWars;

/**
 * Created by Kassy.
 * Date: 2019-12-07
 */

/**
 * Check to see if a string has the same amount of 'x's and 'o's. The method must return a boolean and be case insensitive. The string can contain any char.
 *
 * [해석] 문자열 내에 x 와 y 의 개수가 같으면 true, 다르면 false 를 리턴한다. (대소문자 무시)
 * Examples input/output:
 *---------------------------------------------
 * XO("ooxx") => true
 * XO("xooxx") => false
 * XO("ooxXm") => true
 * XO("zpzpzpp") => true // when no 'x' and 'o' is present should return true
 * XO("zzoo") => false
 * ---------------------------------------------
 */
public class ExesAndOhs {
    public static void main(String[] args) {

        System.out.println(getXO_eunjin("Xxxxertr34"));
        System.out.println(getXO_others("Xxxxertr34"));
    }

    public static boolean getXO_eunjin (String str) {

        int[] a = {0,0};        // 람다식 내에서는 로컬변수를 사용할 수 없으므로, 배열변수를 선언하여 count 값을 담아줌.
        str.toUpperCase().chars().forEach(c -> {
            if("X".codePointAt(0) == c){
                a[0] = a[0] +1 ;
            }else if("O".codePointAt(0) == c){
                a[1] = a[1]+1;
            }
        });
        return a[0] == a[1];

    }

    public static boolean getXO_others (String str) {
        str = str.toLowerCase();
        return str.replace("o","").length() == str.replace("x","").length();

    }
}
