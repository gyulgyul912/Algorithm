package com.algo.programmers;

import java.util.Arrays;

public class 가운데글자가져오기 {

	public static void main(String[] args) {
		
		String s = "asdfc";
		String answer = "";
		String[] sSplit = s.split("");
		
		
		// 길이가 짝수. 중간 두개 반환
		if(s.length()%2 == 0) {
			answer = sSplit[s.length()/2-1].concat(sSplit[s.length()/2]);
		}
		// 길이 홀수 . 한개 반환
		else
		{
			answer = sSplit[s.length()/2];
		}
	}
}
