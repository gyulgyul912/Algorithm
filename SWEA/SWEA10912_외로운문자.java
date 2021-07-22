package com.algo.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA10912_외로운문자 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 1;t<=TC;t++) {
			String ans = "";
			String str = in.readLine();
			int[] alphabet = new int[27];
			for(int i=0;i<str.length();i++) {
					alphabet[str.charAt(i)-96]++;
				
			}
			for(int i=1;i<27;i++) {
				if(alphabet[i]%2==1) {
					ans+=(char)(i+96);
				}
			}
			
			if(ans.equals("")) {
				sb.append("#").append(t).append(" ").append("Good").append("\n");
			}else {
				sb.append("#").append(t).append(" ").append(ans).append("\n");
				
			}
		}
		System.out.println(sb.toString());
	}

}
