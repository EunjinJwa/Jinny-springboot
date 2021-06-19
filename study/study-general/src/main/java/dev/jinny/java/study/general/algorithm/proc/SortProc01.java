package dev.jinny.java.study.general.algorithm.proc;

import java.util.Arrays;

public class SortProc01 {

	/**
	 * [문자열 내마음대로 정렬하기]
	 * 문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다. 
	 * 예를 들어 strings가 [sun, bed, car]이고 n이 1이면 각 단어의 인덱스 1의 문자 u, e, a로 strings를 정렬합니다.

	제한 조건
	strings는 길이 1 이상, 50이하인 배열입니다.
	strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
	strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
	모든 strings의 원소의 길이는 n보다 큽니다.
	인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
	입출력 예
	strings	n	return
	[sun, bed, car]	1	[car, bed, sun]
	[abce, abcd, cdx]	2	[abcd, abce, cdx]
	입출력 예 설명
	입출력 예 1
	sun, bed, car의 1번째 인덱스 값은 각각 u, e, a 입니다. 이를 기준으로 strings를 정렬하면 [car, bed, sun] 입니다.
	 * @param args
	 */
	public static void main(String[] args) {
		
		String[] strings = {"sun", "bed", "car"};
//		solution1(strings, 1);
		solution2(strings, 1);
	}
	
	/**
	 * Arrays.sort를 사용한 정렬 방법
	 * @param strings
	 * @param n
	 * @return
	 */
	public static String[] solution1(String[] strings, int n) {
	      String[] answer = {};
	      
	      for(int i =0; i < strings.length; i++){
	    	  String str = strings[i];
	    	  String nStr = str.substring(n, n+1);
	    	  strings[i] = nStr + str;
	      }
	      
	      Arrays.sort(strings);
	      answer = new String[strings.length];
	      for(int i = 0; i < answer.length; i++){
	    	  answer[i] = strings[i].substring(1);
	      }
	      
	      // 답안 출력
	      for(String a: answer){
	    	  System.out.println(a);
	      }
	      
	      
	      return answer;
	  }
	
	/**
	 * 버블정렬 알고리즘을 사용한 정렬
	 * @param strings
	 * @param n
	 * @return
	 */
	public static String[] solution2(String[] strings, int n) {
	      String[] answer = {};
	      
	      // 제일 앞의 문자열부터 시작해서 제일 큰 문자열을 배열 맨 마지막에 위치시킨다.
	      int k = 1;
	      while(k < strings.length){
	    	  for(int i = 0; i < strings.length-k; i++){
		    	  char nChr = strings[i].charAt(n);
		    	  
		    	  if(nChr > strings[i+1].charAt(n)){
		    		  String tmp = strings[i+1];
		    		  strings[i+1] = strings[i];
		    		  strings[i] = tmp;
		    	  }else if(nChr == strings[i+1].charAt(n)){
		    		  if(strings[i].compareTo(strings[i+1]) > 0){
		    			  String tmp = strings[i+1];
		    			  strings[i+1] = strings[i];
		    			  strings[i] = tmp;
		    		  }
		    	  }
		      }
	    	  
	    	  k++;
	      }
	      
	      
	      answer = new String[strings.length];
	      answer = strings.clone();
	      
	      // 답안 출력
	      for(String a: answer){
	    	  System.out.println(a);
	      }
	      
	      return answer;
	  }
}
