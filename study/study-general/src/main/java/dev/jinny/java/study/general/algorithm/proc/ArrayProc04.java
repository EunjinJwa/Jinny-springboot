package dev.jinny.java.study.general.algorithm.proc;

public class ArrayProc04 {
	
	/**
	 * [자연수 뒤집어 배열로만들기]
	 * 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 
	 * 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
	 * @param args
	 */
	public static void main(String[] args) {
		long n = 9822837;
		solution(n);
	}
	
	public static int[] solution(long n) {
	      int[] answer = {};
	      
	      
	      // 자릿수를 구하기 위해 Math 메서드 사용
	      int len = (int) (Math.log10(n)+1);
	      
	      answer = new int[len];
	      for(int i = 0; i < len; i++){
	    	  answer[i] = (int) (n%10);	// 맨 끝자리를 알기위해 10을 나눈 나머지를 순차적으로 저장한다.
	    	  n = n / 10;				// n은 10을 나눈 몫으로 재저장한다.
	      }
	      
	      for(int i : answer){
	    	  System.out.print(i);
	      }
	      
	      return answer;
	  }

}
