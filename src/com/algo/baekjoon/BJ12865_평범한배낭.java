package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ12865_평범한배낭 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int  N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] weight = new int[N+1];
		int[] value = new int[N+1];	
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(in.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}		
		int[][] dp = new int[N+1][K+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=K;j++) {
				if(j-weight[i]>=0) {
					dp[i][j] = Math.max(dp[i-1][j-weight[i]]+value[i], dp[i-1][j]);
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		System.out.println(dp[N][K]);	
	}

}
