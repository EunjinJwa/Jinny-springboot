package codingTest.training.Stack;

public class PipeRager01 {
	public static void main(String[] args) {
		
		int[] arr = {10,33,8,9};
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
		
		System.out.println("====================");
		for(int d : answer){
			System.out.println(d);
		}
	}

}
