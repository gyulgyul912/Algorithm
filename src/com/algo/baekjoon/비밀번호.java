package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 비밀번호 {
	
	public static void main(String[] args) throws IOException,NumberFormatException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		int m = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int[] login = new int[m];
		
		for(int i=0;i<m;i++) {
			login[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] safety = new int[m+1];
		for(int i=1;i<=n;i++) {
			for(int j=0;j<m;j++) {
				System.out.println(i+" "+login[j]);
				System.out.println(Integer.toBinaryString(i^login[j]));
			}
		}
		
	}

}
