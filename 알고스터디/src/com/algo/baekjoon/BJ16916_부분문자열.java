package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ16916_부분문자열 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String S = in.readLine();
		String P = in.readLine();
		
		int[] pi = new int[P.length()];
		int i = 0;
		for(int j=1;j<P.length();j++) {
			while(i>0 &&P.charAt(i)!=P.charAt(j)) {
				i=pi[i-1];
			}
			if(P.charAt(i)==P.charAt(j)) {
				pi[j] = ++i;
			}
		}
		int result = 0;
		i=0;
		for(int j=0;j<S.length();j++) {
			while(i>0 && S.charAt(j)!=P.charAt(i)) {
				i = pi[i-1];
			}
			if(S.charAt(j)==P.charAt(i)) {
				if(i==P.length()-1) {
					result=1;
					break;
				}else {
					i++;
				}
			}
		}
		System.out.println(result);
		
	}

}
