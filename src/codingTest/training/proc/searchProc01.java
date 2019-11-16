package codingTest.training.proc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class searchProc01 {

	/**
	 * [완전탐색 : 모의고사]
	 * 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 
	 * 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

		1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
		2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
		3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
		
		1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 
		배열에 담아 return 하도록 solution 함수를 작성해주세요.
		
		제한 조건
		시험은 최대 10,000 문제로 구성되어있습니다.
		문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
		가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
		입출력 예
		answers	return
		[1,2,3,4,5]	[1]
		[1,3,2,4,2]	[1,2,3]
		입출력 예 설명
		입출력 예 #1
		
		수포자 1은 모든 문제를 맞혔습니다.
		수포자 2는 모든 문제를 틀렸습니다.
		수포자 3은 모든 문제를 틀렸습니다.
		따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.
		
		입출력 예 #2
		
		모든 사람이 2문제씩을 맞췄습니다.
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] answers = {5,5,5,5, 2, 2};
		solution3(answers);
	}
	
	public static int[] solution1(int[] answers) {
        int[] answer = {};
        
        int[] answerUser1 = new int[answer.length];
        int[] answerUser2 = new int[answer.length];
        int[] answerUser3 = new int[answer.length];
        
//      int[] user1 = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5};//5
//      int[] user2 = {2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, 2};// 8
//      int[] user3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5};// 10
 
        
        int user1Cnt = 0;
        int user2Cnt = 0;
        int user3Cnt = 0;
        
        int idx = 0;
        for(int an : answers){
        	if(answerUser1[idx] == an)
        		user1Cnt++;
        	if(answerUser2[idx] == an)
        		user2Cnt++;
        	if(answerUser3[idx] == an)
        		user3Cnt++;
        }
        
        int maxCnt = user1Cnt;
        if(user2Cnt > maxCnt){
        	maxCnt = user2Cnt;
        }
        if(user3Cnt > maxCnt){
        	maxCnt = user3Cnt;
        }
        
        
        
        return answer;
    }
	
	/**
	 * 정확성 71%
	 * @param answers
	 * @return
	 */
	public static int[] solution2(int[] answers) {
        int[] answer = {};
        
        int[] user1 = new int[answers.length];
        int[] user2 = new int[answers.length];
        int[] user3 = new int[answers.length];
      
        
        for(int i = 0; i < answers.length; i++){
        	// 1번 수포자 점수
        	int ans1 = (i+1) % 5;
        	if(ans1 == 0){
        		ans1 = 5;
        	}
        	user1[i] = ans1;
        	
        	//2번 수포자 점수
        	int ans2;
        	if(i%2 == 0){
        		ans2 = 2;
        	}else{
        		if(i%8 < 5){
        			ans2 = i%8;
        		}else if(i%8 == 7){
        			ans2 = 4;
        		}else{
        			ans2 = 5;
        		}
        	}
        	user2[i] = ans2;
        	
        	// 3번 수포자 점수
        	int ans3;
        	if(i%10<2)
        		ans3=3;
            else if(i%10<4)
            	ans3=1;
            else if(i%10<6)
            	ans3=2;
            else if(i%10<8)
            	ans3=4;
            else 
            	ans3=5;
        	user3[i] = ans3;
        }
        
     
        int[] userAnswerCnt = new int[3];	// 각 사용자의 정답 숫자를 담는 배열
        
        int[][] test = new int[3][];
        test[0] = user1;
        test[1] = user2;
        test[2] = user3;
        
        // 각 사용자별 정답 개수 저장
        for(int i = 0; i < answers.length; i++){
        	int qq = answers[i];
        	for(int j = 0; j < 3; j++){
        		int[] userAn = test[j];
    			if(userAn[i] == qq){
    				userAnswerCnt[j] = userAnswerCnt[j]+1;
    			}
        	}
        }
        
        // 최고 점수를 찾음
        int maxCnt = userAnswerCnt[0];
        for(int i = 0; i < userAnswerCnt.length; i++){
        	if(maxCnt < userAnswerCnt[i]){
        		maxCnt = userAnswerCnt[i];
        	}
        }
        
        // 최고 점수를 가지는 사용자 찾아서 별도의 List에 담는다
        List<Integer> tempUserLsit = new ArrayList<Integer>();
    	for(int i = 0; i < userAnswerCnt.length; i++){
    		if(maxCnt == userAnswerCnt[i]){
    			tempUserLsit.add(i+1);
    		}
    	}
        
        // List에 담긴 값을 최종 return 형식인 배열에 담아준다. 
        answer = new int[tempUserLsit.size()];
        for(int i = 0 ; i < tempUserLsit.size(); i++){
        	answer[i] = tempUserLsit.get(i);
        }
        
        System.out.println("[답안] ===== ");
        for(int a : answer){
        	System.out.println(a);
        }
     
        return answer;
	}
	
	/**
	 * 인터넷 검색
	 * 정확성 71%
	 * @param answers
	 * @return
	 */
	public static int[] solution3(int[] answers) {
		int[] answer = {};
		
		int[] supoja1 = new int[answers.length];
        int[] supoja2 = new int[answers.length];
        int[] supoja3 = new int[answers.length];
      
        
        for(int i = 0; i < answers.length; i++){
        	// 1번 수포자 점수
        	int ans1 = (i+1) % 5;
        	if(ans1 == 0){
        		ans1 = 5;
        	}
        	supoja1[i] = ans1;
        	
        	//2번 수포자 점수
        	int ans2;
        	if(i%2 == 0){
        		ans2 = 2;
        	}else{
        		if(i%8 < 5){
        			ans2 = i%8;
        		}else if(i%8 == 7){
        			ans2 = 4;
        		}else{
        			ans2 = 5;
        		}
        	}
        	supoja2[i] = ans2;
        	
        	// 3번 수포자 점수
        	int ans3;
        	if(i%10<2)
        		ans3=3;
            else if(i%10<4)
            	ans3=1;
            else if(i%10<6)
            	ans3=2;
            else if(i%10<8)
            	ans3=4;
            else 
            	ans3=5;
        	supoja3[i] = ans3;
        }
        
     // @2 
 		List<Integer> list = new ArrayList<Integer>();
 		for (int i = 0; i < 3; i++) list.add(0);
 		
 		// @3 
 		for (int i = 0; i < answers.length; i++) {
 			if (answers[i] == supoja1[i%5]) list.set(0, list.get(0)+1);
 			if (answers[i] == supoja2[i%8]) list.set(1, list.get(1)+1);
 			if (answers[i] == supoja3[i%10]) list.set(2, list.get(2)+1);
 		}
 		
 		int max = Collections.max(list); // @4
 		
 		// @5
 		List<Integer> returnList = new ArrayList<Integer>();
 		for(int i=0; i<list.size(); i++) if(max == list.get(i)) returnList.add(i+1);
 		
 		// @6
 		answer = new int[returnList.size()];
 		for(int i=0; i<returnList.size(); i++) 
 			answer[i] = returnList.get(i);
		
		
		return answer;
	}
}
