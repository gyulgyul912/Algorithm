package com.algo.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1926_간단한369게임 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		String ans = "";
		for(int i=1;i<=N;i++) {
			String now = Integer.toString(i);
			int cnt = 0;
			for(int j=0;j<now.length();j++) {
				if(now.charAt(j)=='3' || now.charAt(j)=='6' || now.charAt(j)=='9') {
					ans+="-";
					cnt++;
				}
			}
			if(cnt==0)ans+=i;
			ans+=" ";
		}
		System.out.println(ans);
	}

}
