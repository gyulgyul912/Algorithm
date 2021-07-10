package com.algo.programmers;

public class 두정수사이의합 {
	
	public static void main(String[] args) {
		
	}
	 static public long solution(int a, int b) {
	        long answer = 0;
	        if(a==b){
	        	answer = a;
	        return answer;
	        }else{
	            int max = a>b ? a : b;
	            int min = a<b ? a : b;
	            
	            for(int i = min;i<=max;i++) {
	            	answer+=i;
	            }
	   	   	 return answer;
	        }

	    }


}
