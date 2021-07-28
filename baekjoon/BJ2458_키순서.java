package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2458_키순서 {
	
	
	static int INF = 1000;
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] students = new int[N+1][N+1];
		
//		for(int i=1;i<=N;i++) {
//			Arrays.fill(students[i], INF);
//			students[i][i] = 0;
//		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			students[a][b] = 1;	
		}

		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(k==i || k==j ||i==j)continue;
//					students[i][j]>students[i][k]+studetns[k][j]
					if(students[i][k]==1 &&students[k][j]==1) {
						students[i][j] = 1;
					}
				}
			}
		}
		int ans = 0;
		for(int i=1;i<=N;i++) {
			int cnt = 0;
			for(int j=1;j<=N;j++) {
				if(i==j)continue; 
				if(students[i][j]==1 || students[j][i]==1)cnt++;
			}
			if(cnt==N-1)ans++;
		}
		System.out.println(ans);
		
	}

}
