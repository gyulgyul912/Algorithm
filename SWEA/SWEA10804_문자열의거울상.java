package com.algo.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA10804_문자열의거울상 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 1;t<=TC;t++) {
			String ans = "";
			String str = in.readLine();
			for(int i=str.length()-1;i>=0;i--) {
				switch(str.charAt(i)){
				case('b'):{
					ans+="d";
					break;
				}case('d'):{
					ans+="b";
					break;
				}case('p'):{
					ans+="q";
					break;
				}case('q'):{
					ans+="p";
					break;
				}
				}
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}

}
