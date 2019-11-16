package codingTest.training.Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class HashProc01 {
	
	public static void main(String[] args) {
		String[][] clothes = new String[5][];
		clothes[0] = new String[]{"yellow_hat", "headgear"};
		clothes[1] = new String[]{"blue_sunglasses", "eyewear"};
		clothes[2] = new String[]{"green_turban", "headgear"};
		clothes[3] = new String[]{"green_turban", "type3"};
		clothes[4] = new String[]{"green_turbanss", "type3"};
//		
//		clothes[0] = new String[]{"crow_mask", "face"};
//		clothes[1] = new String[]{"blue_sunglasses", "face"};
//		clothes[2] = new String[]{"smoky_makeup", "face"};
		
		solution1(clothes);
	}
	
	public static int solution1(String[][] clothes) {
        int answer = 0;
        
        HashMap<String, Integer> dataMap = new HashMap<String, Integer>();
        
        // 의상의 종류별 개수를 HashMap에 저장
        for(String[] cl : clothes){
        	if(dataMap.containsKey(cl[1])){
        		dataMap.put(cl[1], dataMap.get(cl[1]) + 1);
        	}else{
        		dataMap.put(cl[1], 2);	// 경우의 수 : 안입는 경우도 있으므로, 초기값을 2로 설정
        	}
        }
        
        System.out.println(dataMap);
        if(dataMap.keySet().size() > 1){
        	answer = 1;
        	for(String key : dataMap.keySet()){
        		int val = dataMap.get(key);
        		System.out.println(answer + " * " + val);
        		answer = answer * val;
        	}
        	answer = answer -1;
        }else{
        	answer = clothes.length;
        }
        
        // 답안 출력
        System.out.println(answer);

		System.out.println("숫자를 입력하세요 : ");
        
//        InputStreamReader cnt = new InputStreamReader(System.in);
        BufferedReader cnt = new BufferedReader(new InputStreamReader(System.in));
        int cntN = 0;     
    	try {
			String input = cnt.readLine();
			cntN = Integer.parseInt(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
        System.out.println(">> " + cntN);
        
        return answer;
    }

}
