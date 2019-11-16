package codingTest.training.proc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SysteminProc01 {
	public static void main(String[] args) {
		
		try {
			// 키보드로부터 입력받음
			System.out.println("숫자를 입력하세요");
		    BufferedReader lineNum = new BufferedReader(new InputStreamReader(System.in));
		    // 입력받은 문자열 한 줄을 읽어서 변수에 담는다.
		    int inputCnt = Integer.parseInt(lineNum.readLine());
		    String input = "Hello";
		    for(int i = 0; i < inputCnt; i++){
		     System.out.println(input); 
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
