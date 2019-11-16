package codingTest.nsus_codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CharReverse01 {

	/**
	 * You are given an integer N, followed by N lines of input (1 <= N <= 100). 
	 * Each line of input contains one or several words separated with single spaces. 
	 * Each word is a sequence of letters of English alphabet containing between 1 and 10 characters, 
	 * inclusive. The total number of words in the input is between 1 and 100, inclusive.

	Your task is to reverse the order of words in each line of input, while preserving the words themselves. 
	The lines of your output should not have any trailing or leading spaces.
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
		      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		      String input = br.readLine();
		      int lineCnt = Integer.parseInt(input);
		      
		      String[] arr = new String[lineCnt];
		      for(int i = 0; i < lineCnt; i++){
		        arr[i] = br.readLine();
		      }
		      
		      for(int i = 0; i < arr.length; i++){
		        String str = "";
		        List<String> chrArr = new ArrayList();
		        for(int k = 0; k < arr[i].length(); k++){
		          if(arr[i].charAt(k) != ' '){
		            str = str + arr[i].charAt(k);
		            if(k == arr[i].length()-1){
		              chrArr.add(str);
		            }
		          }else{
		            chrArr.add(str);
		            chrArr.add(" ");
		            str = "";
		          }
		        }
		        
		        for(int j = chrArr.size()-1; j >= 0; j--){
		          System.out.print(chrArr.get(j));
		        }
		        System.out.println();
		      }
		    
		    
		      
		    } catch (IOException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
		
	}
}
