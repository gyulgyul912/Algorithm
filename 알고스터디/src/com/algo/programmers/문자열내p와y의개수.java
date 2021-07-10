package com.algo.programmers;

import java.util.Arrays;
import java.util.Comparator;

public class 문자열내p와y의개수 {
	
	public static void main(String[] args) {
		Arrays.sort(args, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub		
				return o1.compareTo(o2);
			}
		});
		System.out.println(solution("pPoooyY"));
	}
	
    static boolean solution(String s) {
    	// 변환한 다음 대입해야하네..
    	s = s.toLowerCase();
    	System.out.println(s);
        boolean answer = true;
        int length = s.length();
        // char 공백초기화       
        int pCnt = 0;
        int yCnt = 0;
        for(int i=0;i<length;i++) {
        	if(s.charAt(i)=='p') {
        		pCnt++;
        	}else if(s.charAt(i)=='y') {
        		yCnt++;
        	}
        }
        if(pCnt==yCnt) {
        	return answer = true;
        }else if(pCnt!=yCnt) {
        	return answer = false;
        }else{
        	return answer = true;
        }


    }

}
