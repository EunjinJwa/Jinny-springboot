package codingTest.training.proc;

public class CharProc05 {

	/**
	 * [가운데 글자 가져오기]
	 * 단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 
	 * 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.

		재한사항
		s는 길이가 1 이상, 100이하인 스트링입니다.
		입출력 예
		s	return
		abcde	c
		qwer	we
	 * @param args
	 */
	public static void main(String[] args) {
		solution("abd");
	}
	
	public static String solution(String s) {
      String answer = "";
      
      if(!"".equals(s)){
    	  int sLength = s.length();
    	  int centerNum = sLength/2;
    	  
    	  answer = sLength % 2 == 0 ? s.substring(centerNum-1, centerNum+1) : s.substring(centerNum, centerNum+1);
      }
      
      // 답안 출력
      System.out.println(answer);
      return answer;
  }
}
