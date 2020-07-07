package com.jinny.java.general.codingTest.training.proc;
import java.util.regex.Pattern;


public class CharProc01 {
/**
 * [문자열 다루기 기본]
	문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 
	예를 들어 s가 a234이면 False를 리턴하고 1234라면 True를 리턴하면 됩니다.
	
	제한 사항
	s는 길이 1 이상, 길이 8 이하인 문자열입니다.
	입출력 예
	s	return
	a234	false
	1234	true
 */
	
	public static void main(String[] args) {
		String s = "999999";
		System.out.println(solution1(s));
	}
	
  public static boolean solution1(String s) {
      boolean answer = true;
      
      if(s.length() == 4 || s.length() == 6){
          
	      for(int i = 0; i < s.length(); i++){
	    	  System.out.println(s.charAt(i));
	    	  if(s.charAt(i) < '0' || s.charAt(i) > '9'){
	    		  answer = false;
	    		  break;
	    	  }
	      }
      }else{
    	  answer = false;
      }
      return answer;
  }
  
  public static boolean solution2(String s){
	  boolean answer = true;
	  
	  if(s.length() == 4 || s.length() == 6){
          try{
              Integer.parseInt(s);
          }catch(NumberFormatException e){
              answer = false;
          }
      }else{
          answer = false;
      }
	  
	  return answer;
  }
}
