package codingTest.training.Hash;

import java.util.HashMap;

public class ArrCompare01 {
	
	/**
	 * 
	 * [완주하지 못한 선수]
	 * 	# 문제 설명
		수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
		마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 
		완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
		
		# 제한사항
		마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
		completion의 길이는 participant의 길이보다 1 작습니다.
		참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
		참가자 중에는 동명이인이 있을 수 있습니다.
		
		
	 */

	public static void main(String[] args) {
		
		// Case 1.
//		String[] participant = {"leo", "kiki", "eden"};
//		String[] completion = {"eden", "kiki"};
		
		// Case 2.
//		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
//		String[] completion = {"josipa", "filipa", "marina", "nikola"};
		
		// Case 3.
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		
		
		String value = solution3(participant, completion);
		System.out.print("answer : " + value);
		
	}
	
	
	/**
	 * For문으로 배열 내에서 해결
	 * 정확성은 100% 효율성이 떨어짐
	 * @param participant
	 * @param completion
	 * @return
	 */
	private static String solution1(String[] participant, String[] completion){
        String answer = "";
        
        for(int i = 0; i < participant.length; i++){
        	String name = participant[i];
        	for(int j = 0; j < completion.length; j++){
        		if(name.equals(completion[j])){
        			participant[i] = "";
        			completion[j] = "";
        			break;
        			
        		}
        	}
        }
        
        for(int i = 0; i < participant.length; i++){
        	System.out.println(participant[i]);
        	if(!"".equals(participant[i])){
        		answer = participant[i];
        	}
        }
        
        return answer;
	}
	
	
	/**
	 * HashMap 사용
	 * 인터넷검색 답안
	 * @param participant
	 * @param completion
	 * @return
	 */
	private static String solution2(String[] participant, String[] completion){
		String answer = "";
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
        int val = 0;

        for (String part : participant) {
            if (map.get(part) == null) {
                map.put(part, 1);
            } else {
                val = map.get(part) + 1;
                map.put(part, val);
            }
        }
        
        for (String comp : completion) {
            val = map.get(comp) - 1;
            map.put(comp, val);
        }
        
        for (String key : map.keySet()) {
            if (map.get(key) == 1) {
                answer = key;
            }
        }
		
		return answer;
	}
	
	
	/**
	 * HashMap 을 사용하여 다시 풀이
	 * 정확성, 효율성 100%
	 * @param participant
	 * @param completion
	 * @return
	 */
	private static String solution3(String[] participant, String[] completion){
		String answer = "";
		
		HashMap<String, Integer> userMap = new HashMap<String, Integer>();
		
		// HashMap을 선언하여 참여자의 이름별로 Count 값을 담는다. (기본적으로 1, 동명이인은 2 이상이 담김. )
		for(String par : participant){
			int value = 1;
			if(userMap.containsKey(par)){
				value = userMap.get(par)+1;
			}
			userMap.put(par, value);
		}
		
		// 완주자 배열을 돌면서, HashMap 에서 참여자의 Count에 확인되는 완주자 만큼 -1 을 한다. 
		for(String comp : completion){
			userMap.put(comp, userMap.get(comp)-1);
		}
		
		
		// 결론적으로 value 가 1 인 참여자가 완주하지 못한 참여자가 된다. !! 
		for(String key : userMap.keySet()) {
			if(userMap.get(key) == 1){
				answer = key;
			}
		}
		
		return answer;
	}
	

}
