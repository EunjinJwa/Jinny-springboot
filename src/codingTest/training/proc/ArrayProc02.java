package codingTest.training.proc;

import java.util.Arrays;

public class ArrayProc02 {
	/**
	 * [k번째수]
	 * 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

		예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], 
		i = 2, j = 5, k = 3이라면
		
		array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
		1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
		2에서 나온 배열의 3번째 숫자는 5입니다.
		배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, 
		commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
		
		제한사항
		array의 길이는 1 이상 100 이하입니다.
		array의 각 원소는 1 이상 100 이하입니다.
		commands의 길이는 1 이상 50 이하입니다.
		commands의 각 원소는 길이가 3입니다.
		입출력 예
		array	commands	return
		[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
		입출력 예 설명
		[1, 5, 2, 6, 3, 7, 4]를 2번째부터 5번째까지 자른 후 정렬합니다. [2, 3, 5, 6]의 세 번째 숫자는 5입니다.
		[1, 5, 2, 6, 3, 7, 4]를 4번째부터 4번째까지 자른 후 정렬합니다. [6]의 첫 번째 숫자는 6입니다.
		[1, 5, 2, 6, 3, 7, 4]를 1번째부터 7번째까지 자릅니다. [1, 2, 3, 4, 5, 6, 7]의 세 번째 숫자는 3입니다.
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = new int[3][];
		commands[0] = new int[]{2, 5, 3};
		commands[1] = new int[]{4, 4, 1};
		commands[2] = new int[]{1, 7, 3};
		
		solution2(array, commands);
		
	}

	/**
	 * 정확도 100%
	 * @param array
	 * @param commands
	 * @return
	 */
	 public static int[] solution1(int[] array, int[][] commands) {
        int[] answer = {};
        answer = new int[commands.length];
        
     // 각 자른 자릿수 내의 배열값으로 새로운 배열 생성하여 담아준다. 
        for(int i = 0; i < commands.length; i++){
        	int[] command = commands[i];
        	int minIdx = command[0] -1;
        	int maxIdx = command[1] -1;
        	int k = command[2] -1;
        	
        	int[] procArr = new int[maxIdx - minIdx + 1];
        	
        	int idx = 0;
        	for(int j = minIdx; j <= maxIdx; j++){
        		procArr[idx] = array[j];
        		idx++;
        	}
        	
        	// 오름차순 정렬
        	Arrays.sort(procArr);
        	
        	// k번째 수를 별도의 배열에 담아준다.
        	answer[i] = procArr[k];
        }
        
        // 결과 출력
        for(int d : answer){
        	System.out.println(d);
        }
        
        
        return answer;
    }
	 
	 
	 /**
		 * 다른방법으로 풀어보기
		 * 정확도 100%
		 * Arrays.copyOfRange   
		 * @param array
		 * @param commands
		 * @return
		 */
		 public static int[] solution2(int[] array, int[][] commands) {
	        int[] answer = {};
	        answer = new int[commands.length];
	        
	        int idx = 0;
	        for(int[] command : commands){
	        	int minIdx = command[0] -1;
	        	int maxIdx = command[1]-1;
	        	int k = command[2] -1;
	        	
	        	int[] procArr = Arrays.copyOfRange(array, minIdx, maxIdx+1);
	        	Arrays.sort(procArr);
	        	answer[idx] = procArr[k];
	        	idx++;
	        }
	        
	        // 결과 출력
	        for(int d : answer){
	        	System.out.println(d);
	        }
	        
	        
	        return answer;
	    } 
		 
		 /**
		  * 인터넷 정답
		  * @param array
		  * @param commands
		  * @return
		  */
		 public static int[] solution3(int[] array, int[][] commands) {
		    int[] answer = {};
		    answer = new int[commands.length];

	        for(int i=0; i<commands.length; i++){
	            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
	            Arrays.sort(temp);
	            answer[i] = temp[commands[i][2]-1];
	        }
	        
	     // 결과 출력
	        for(int d : answer){
	        	System.out.println(d);
	        }
	        
	        return answer;
		 }
}
