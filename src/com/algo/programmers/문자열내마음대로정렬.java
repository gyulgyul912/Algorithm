package com.algo.programmers;

import java.util.Arrays;

public class 문자열내마음대로정렬 {
	
	public static void main(String[] args) {
		String[] str = {"abce","abcd","cdx"};
		solution(str,2);
	}
	 static public String[] solution(String[] strings, int n) {
	        String[] answer = {};
	        // 자르고 붙이는 배열
	        String[] temp = new String[strings.length];
	        int size = strings.length;
	        for(int i=0;i<size;i++) {
	        	// n~end + 0~n-1 
	        	temp[i] = strings[i].substring(n)+strings[i].substring(0,n);
	        }
	        // index n 기준으로 정렬
	        Arrays.sort(temp);

	        for(int i=0;i<size;i++) {
	        	// 뒤에 붙인 n개 앞으로 붙이기
	        	temp[i] = temp[i].substring(temp[i].length()-n)+temp[i].substring(0,temp[i].length()-n);	     
	        }
	        // n번째가 같은 것들은 사전순으로 정렬
	        for(int i=0;i<size;i++) {
	        	int k=1;
	        	// 같지 않을때까지 비교해서 같은 개수 구하기
	        	while(i+k<size && temp[i].charAt(n)==temp[i+k].charAt(n)) {
	        		k++;
	        	}
	        	// 같은게 있다면 부분 정렬
	        	if(k>1) {
	        		Arrays.sort(temp, i, i+k);
	        	}
	        }
	        answer = temp;     
	        
	        return answer;
	    }

}
