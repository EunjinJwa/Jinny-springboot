package com.jinny.java.general.codingTest.training.proc;

public class ArrProc01 {

	/**
	 * 배열에서 최소값을 제외하기
	 * 2019.05.01
	 */
	public static void main(String[] args) {
		int[] arr = {10,33,8,9};
		int[] resultArr = solution(arr);
		
		for(int d : resultArr){
			System.out.println(d);
		}
	}
	
	public static int[] solution(int[] arr){
		
		int[] answer = {};
		int arrLength = arr.length;
		
		if(arrLength == 1){
	      answer = new int[1];
	      answer[0] = -1;
		}else{
			answer = new int[arrLength-1];
			int answerIdx = 0;
			for(int i = 0; i < arrLength; i++){
				int tempVal = arr[i];
				for(int j = 0; j < arrLength; j++){
					if(i != j && tempVal > arr[j]){
						answer[answerIdx] = tempVal;
						answerIdx++;
						break;
					}
				}
			}
		}
		
		return answer;
	}
	
}
