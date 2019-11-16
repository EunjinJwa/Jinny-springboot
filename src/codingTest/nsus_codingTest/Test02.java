package codingTest.nsus_codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class Test02 {

	/**
	 * 표준 입력을 통해 개행문자로 구분된 alphabet 소문자 5개 이내로 이루어진 단어가 입력 됩니다. 
	 * 단어 목록의 끝을 나타내는 문자열 "====="를 입력받으면 입력을 종료하면 됩니다.
		입력받은 모든 단어에 대해 첫번째 문자부터 만들 수 있는 모든 하위 단어 집합 (sub sequnce)의 사용 빈도를 계수한 뒤 
		alphabet 순으로 정렬하여 "단어 갯수" 형식으로 행으로 나누어 출력해 주세요.
		
		 
		
		예를 들면 다음과 같은 입력을 받으면,
		
		ada
		bean
		adam​
		ace
		be
		ac
		=====
		 
		
		다음과 같이 출력해 주시면 됩니다.
		
		a 4
		ac 2
		ace 1
		ad 2
		ada 2
		adam 1
		b 2
		be 2
		bea 1
		bean 1
		결과에 설명을 덧 붙이자면 다음과 같습니다.
		
		a 4 // ada adam ace ac
		ac 2 // ace ac
		ace 1 // ace
		ad 2 // ada adam
		ada 2 // ada
		adam 1 // adam
		b 2 // bean be
		be 2 // bean be
		bea 1 // bean
		bean 1 // bean
	 * @param args
	 */
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			List<String> wordList = new ArrayList<String>();
	        for(String input = br.readLine(); !input.equals("====="); input = br.readLine()) {
	            wordList.add(input);
	        }
	        
	        // 하위 단어집합별 갯수를 TreeMap 으로 저장
	        TreeMap<String,Integer> strMap = new TreeMap<String,Integer>(); 
	        for(int i = 0; i < wordList.size(); i++){
	        	String word = wordList.get(i).trim();
	        	for(int k = 1; k <= word.length(); k++){
	        		String key = word.substring(0,k);
	        		if(strMap.containsKey(key)){
	        			strMap.put(key, strMap.get(key)+1);
	        		}else{
	        			strMap.put(key, 1);
	        		}
	        	}
	        }
	        
	        // 정렬
	        Iterator<String> keys = strMap.keySet().iterator();
	        
	        // 출력
	        String key;
	        int value;
	        while(keys.hasNext()) { 
	        	key = (String)keys.next(); 
	        	value = strMap.get(key); 
	        	System.out.println(key+" "+value); 
	        }

		} catch (Exception e) {
			e.printStackTrace();
		}   finally{
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
