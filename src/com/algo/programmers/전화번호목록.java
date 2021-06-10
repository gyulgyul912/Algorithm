package com.algo.programmers;

public class 전화번호목록 {
	
	public static void main(String[] args) {
		String[] phone= {"12","123","1235","567","88"};
		solution(phone);
	}
	
	public static boolean solution(String[] phone_book) {
        boolean answer = true;
        
        for(int i=0;i<phone_book.length;i++) {
        	String head = phone_book[i];
        	for(int j=0;j<phone_book.length;j++) {
        		if(i!=j && head.length()<=phone_book[j].length()) {
        			int k=0;
        			for(;k<head.length();k++) {
        				if(head.charAt(k)==phone_book[j].charAt(k)) continue;
        				break;
        			}
        			if(k==head.length()) {
        				answer=false;
        				break;
        			}
        		}
        		if(answer==false)
        			break;
        	}
        	if(answer==false)
    			break;
        }
        System.out.println(answer);
        return answer;
    }

}
