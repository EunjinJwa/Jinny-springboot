package codingTest.nsus_codingTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test05 {

	/**
	 * 표준 입력을 통해 공백으로 구분된 0 이상의 자연수 n 개가 주어집니다. 각 자연수는 시계열 값 y로, 수직 막대 그래프로 표현될 수 있습니다.
		예를 들면 다음과 같은 입력을 받으면,
		2 1 5 6 2 3
		아래와 같은 그래프로 표현할 수 있습니다.
		
		histogram
		이렇게 표현된 그래프 내에서 가장 넓은 영역을 차지하고 있는 단일 사각형의 넓이를 찾아서 반환하세요.
		예를 들면 위의 그래프에서 가장 넓은 사각형은 `2x5`의 크기를 가지고 있는 다음 영역입니다.
		rectangle
		그러므로, 이 사각형의 넓이 `10`을 다음과 같이 출력해 주시면 됩니다.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String input = br.readLine();
	        String[] hArr = input.split(" ");
	        int maxArea = 0;
	        for(int i = 0; i < hArr.length; i++){
	        	int cnt = 1;
	        	int height = Integer.parseInt(hArr[i]);
	        	boolean isConn = true;
	        	int idx = 1;
	        	// 오른쪽으로 반복
	        	do {
	        		if((i+idx) < hArr.length){
	        			if(height <= Integer.parseInt(hArr[i+idx])){
			        		cnt++;
			        		idx++;
			        	}else{
			        		isConn = false;
			        	}
	        		}else{
	        			isConn = false;
	        			idx = 1;
	        		}
	        	}while(isConn);
	        	
	        	//왼쪽으로 반복
	        	isConn = true;
	        	do{
	        		if(idx > 0 && (i-idx) >= 0){
	        			if(height <= Integer.parseInt(hArr[i-idx])){
			        		cnt++;
			        		idx++;
			        	}else{
			        		isConn = false;
			        	}
	        		}else{
	        			isConn = false;
	        			idx = 1;
	        		}
	        	}while(isConn);
	        	
	        	// 최대넓이값 비교
	        	int thisArea = height * cnt;
	        	if(maxArea <= thisArea){
	        		maxArea = thisArea;
	        	}
	        }
	        System.out.println(maxArea);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
