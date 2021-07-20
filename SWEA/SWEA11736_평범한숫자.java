package com.algo.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA11736_평범한숫자 {
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=TC;t++) {
			
			int N = Integer.parseInt(in.readLine());
			int[] num = new int[N];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int i=0;i<N;i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			int cnt = 0;
			for(int i=1;i<N-1;i++) {
				if(num[i]>num[i-1] && num[i]<num[i+1] || num[i]<num[i-1] && num[i]>num[i+1])
					cnt++;
			}
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		
		}
		System.out.println(sb.toString());
	}

}
