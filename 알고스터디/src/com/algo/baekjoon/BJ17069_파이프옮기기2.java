package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ17069_파이프옮기기2 {
	static int N;
	static int[][] house;
	static long[][][] dp;
	static int garo = 0;
	static int sero = 1;
	static int daegak = 2;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		house = new int[N + 1][N + 1];
		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= N; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp = new long[N+1][N+1][3];
		dp[1][2][garo] = 1;
		for(int i=1;i<=N;i++) {
			for(int j=3;j<=N;j++) {
				if(house[i][j]==0) {
					// 가로
					dp[i][j][garo] = dp[i][j-1][garo]+dp[i][j-1][daegak];
					// 세로
					dp[i][j][sero] = dp[i-1][j][sero]+dp[i-1][j][daegak];
					// 대각선
					if(house[i-1][j]==0 && house[i][j-1]==0) {
						dp[i][j][daegak] = dp[i-1][j-1][garo]+dp[i-1][j-1][sero]+dp[i-1][j-1][daegak];
					}
				}
				
			}
		}
		System.out.println(dp[N][N][garo]+dp[N][N][sero]+dp[N][N][daegak]);
	}




}
