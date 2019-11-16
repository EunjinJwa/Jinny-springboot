package codingTest.training.proc;

import java.util.Arrays;

public class SortProc02 {

	/**
	 * [문자열 내림차순으로 배치하기]
	 * 문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
		s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
		
		제한 사항
		str은 길이 1 이상인 문자열입니다.
		입출력 예
		s	return
		Zbcdefg	gfedcbZ
	 * @param args
	 */
	public static void main(String[] args) {
	
		String s = "DFabuP";
		solution(s);
	}
	
	public static String solution(String s) {
	      String answer = "";
	      
	      char[] arr = s.toCharArray();
	      Arrays.sort(arr);
	      String s1 = new String(arr);
	      
	      answer = new StringBuilder(s1).reverse().toString();
	      
	      // 답안 출력
	      System.out.println(answer);
	      
	      return answer;
	  }

}
