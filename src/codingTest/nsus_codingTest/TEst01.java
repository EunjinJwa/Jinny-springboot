package codingTest.nsus_codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TEst01 {
	
	/**
	 * N 개의 값으로 이루어진 배열이 주어졌을 때, 주어진 K 횟수 만큼 오른쪽으로 배열을 회전(rotating) 시킵니다. 
	 * 모든 원소는 오른쪽으로 K 만큼 이동하게 되며, 배열 오른쪽 밖으로 밀려난 원소는 왼쪽으로부터 추가됩니다. 
	 * 예를 들면 K=1 일때, 가장 오른쪽에서 있던 원소는 왼쪽 첫번째 위치로 이동하게 됩니다.

		예를 들면, 배열 [3, 8, 9, 7, 6] 을 한번 회전시키면 [6, 3, 8, 9, 7] 이 되고, K = 3 번 회전 시키면 [9, 7, 6, 3, 8] 이 됩니다.
		
		입력은 두 행의 표준 입력입니다.
		
		첫 번째 행은 space 로 구분된 문자열입니다.
		두 번째 행은 회전시킬 횟수 K 값입니다. 값 K는 반드시 정수로만 주어집니다.
		예를들면 다음과 같은 입력이 주어졌을 때
		
		3 8 9 7 6
		3
		다음과 같이 출력해주시면 됩니다.
		
		9 7 6 3 8
	 * @param args
	 */
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      try {
	        String input = br.readLine();
	        int cnt = Integer.parseInt(br.readLine());
	        
	        // 공백을 기준으로 배열 생성
	        String[] arr = input.split(" ");
	        String[] newArr = new String[arr.length];
	        
	        // 회전수에 따라 변경된 위치로 신규배열에 원소 배치
	        for(int i = 0; i < arr.length; i++){
	          if((i+cnt) > (arr.length-1)){
	            newArr[i+cnt - arr.length] = arr[i];
	          }else{
	            newArr[i+cnt] = arr[i];
	          }
	        }

	        // 답안 출력
	        String s = "";
	        for(String a : newArr) {
	          System.out.print(s + a);
	          s = " ";
	        }
	      } catch (IOException e) {
	        e.printStackTrace();
	      }finally{
	        try {
	          if(br != null){
	              br.close();
	          }
	        } catch (IOException e) {
	          e.printStackTrace();
	        }
	      }
	}

}
