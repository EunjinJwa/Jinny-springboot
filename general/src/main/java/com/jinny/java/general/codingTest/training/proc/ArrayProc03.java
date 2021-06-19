package com.jinny.java.general.codingTest.training.proc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * [같은 숫자는 싫어]
 * 배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다. 
 * 이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다. 배열 arr에서 제거 되고 남은 수들을 return 하는 solution 함수를 완성해 주세요. 
 * 단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다.
	예를들면
	arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
	arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
	배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.
	
	제한사항
	배열 arr의 크기 : 1,000,000 이하의 자연수
	배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수
	입출력 예
	arr	answer
	[1,1,3,3,0,1,1]	[1,3,0,1]
	[4,4,4,3,3]	[4,3]
 * @author eunji
 *
 */
public class ArrayProc03 {
	public static void main(String[] args) {
		
		int[] arr = {1,1,1,5,5,4,4,8};
		int[] arr2 = {1, 1, 3, 3, 0, 1, 1};
//		solution(arr); // 성공
//		solution(arr2); // 실패
		
//		solution2(arr2);
		
		solution3(arr2);
		
	}
	
	/**
	 * 틀린 로직이나, LinkedHashMap 을 사용하여 배열의 기존정렬을 유지함 
	 * @param arr
	 * @return
	 */
	public static int[] solution(int []arr) {
        int[] answer = {};
        
        LinkedHashMap<Integer, Integer> dataMap = new LinkedHashMap<Integer, Integer>();
        for(int i =0; i < arr.length; i++){
        	
        	if(dataMap.containsKey(arr[i])){
        		dataMap.put(arr[i], dataMap.get(arr[i]++));
        	}else{
        		dataMap.put(arr[i], 1);
        	}
        }
        answer = new int[dataMap.keySet().size()];
        int idx = 0;
        for(int key : dataMap.keySet()){
        	answer[idx] = key;
        	idx++;
        }
        
        // 답안출력
        for(int a : answer){
        	System.out.println(a);
        }
        
        return answer;
	}
	
	/**
	 * 정답률 100%
	 * 효율성 1개 실패
	 * @param arr
	 * @return
	 */
	public static int[] solution2(int []arr) {
        int[] answer = {};
        
        LinkedHashMap<Integer, Integer> dataMap = new LinkedHashMap<Integer, Integer>();
        
        int k = 1;
        int arrNum = arr[0];
        dataMap.put(0, arrNum);
        int idx = 1;
        for(int i = 1; i < arr.length; i++){
        	if(arrNum == arr[i]){
        	}else{
        		arrNum = arr[i];
        		dataMap.put(idx, arr[i]);
        		idx++;
        	}
        }

        answer = new int[dataMap.keySet().size()];
        for(int key : dataMap.keySet()){
        	answer[key] = dataMap.get(key);
        }
        
        // 답안출력
        for(int a : answer){
        	System.out.println(a);
        }
        
        
        
        return answer;
	}
	
	/**
	 * List 사용
	 * 정확성 100% 효율성 100%
	 * @param arr
	 * @return
	 */
	public static int[] solution3(int []arr) {
        int[] answer = {};
        
        List<Integer> intList = new ArrayList<Integer>();
        Integer iNum = null;
        for(int i = 1; i < arr.length; i++){
        	if(iNum == null ){
        		iNum = arr[i];
        		intList.add(iNum);
        	}
        	
        	if(iNum != arr[i]){
        		intList.add(arr[i]);
        		iNum = arr[i];
        	}
        }
        
        answer = new int[intList.size()];
        for(int i = 0; i < answer.length; i++){
        	answer[i] = intList.get(i);
        }
        
     // 답안출력
        for(int a : answer){
        	System.out.println(a);
        }
        
        return answer;
	}

}
