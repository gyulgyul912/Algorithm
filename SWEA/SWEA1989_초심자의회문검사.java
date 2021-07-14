package com.algo.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1989_초심자의회문검사 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(in.readLine());
		StringBuilder sb= new StringBuilder();
		for(int t=1; t<=TC;t++) {
			int answer = 0;
			
			String word = in.readLine();
			int f = 0;
			int l = word.length()-1;
			while(f<l) {
				if(word.charAt(f)!=word.charAt(l)) {
					break;
				}
				f++;
				l--;
			}
			if(f>=l)answer=1;
			sb.append("#").append(t).append(" ").append(answer).append("\n");
			
		}
		System.out.println(sb);
	}

}
