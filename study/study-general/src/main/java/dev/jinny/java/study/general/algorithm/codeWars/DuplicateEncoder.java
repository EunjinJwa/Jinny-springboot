package dev.jinny.java.study.general.algorithm.codeWars;

/**
 * Created by Kassy.
 * Date: 2019-12-15
 */

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * The goal of this exercise is to convert a string to a new string where each character in the new string is
 * "(" if that character appears only once in the original string, or ")" if that character appears more than
 * once in the original string.
 * Ignore capitalization when determining if a character is a duplicate.
 *
 * Exam
 * "din"      =>  "((("
 * "recede"   =>  "()()()"
 * "Success"  =>  ")())())"
 * "(( @"     =>  "))(("
 */
public class DuplicateEncoder {

    public static void main(String[] args) {

        System.out.println(encode_others("test"));
    }

    // 이중for문으로 풀음. 뭐.. 이상함 ㅠㅠ
    static String encode(String word){
        word = word.toLowerCase();
        String[] newWord = new String[word.length()];

        for(int i = 0; i < word.length(); i++) {
            String ch = String.valueOf(word.charAt(i));
            int chCnt = 0;
            for (int k = 0; k < word.length(); k++) {
                if (String.valueOf(word.charAt(k)).equals(ch)) chCnt++;
            }
            String encodeKey = "(";
            if (chCnt > 1) {
             encodeKey = ")";
            }
            for (int k = 0; k < word.length(); k++) {
                if (String.valueOf(word.charAt(k)).equals(ch)) {
                    newWord[k] = encodeKey;
                }
            }
        }
        return Arrays.stream(newWord).collect(Collectors.joining());
    }

    /**
     * indexOf , lastIndexOf
     * 를 활용하여 중복여부를 확인할 수 있다.
     * @param word
     * @return
     */
    static String encode_others(String word) {
        word = word.toLowerCase();
        String result = "";
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            result += (word.indexOf(ch) == word.lastIndexOf(ch)) ? "(" : ")";
        }
    return result;
    }







}
