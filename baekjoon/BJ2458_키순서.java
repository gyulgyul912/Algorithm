package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2458_키순서 {
	
	static int[][] students;
	static int INF = 1000;
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		students = new int[N][N];
		for(int i=0;i<N;i++) {
			Arrays.fill(students[i], INF);
			students[i][i] = 0;
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;			
			students[from][to] = 1;
		}
		// FloydWarshall
		for(int k=0;k<N;k++) { // 경유지
			for(int i=0;i<N;i++) { // 출발점
				for(int j=0;j<N;j++) { // 도착점
					if(i==j ||k==i ||k==j)continue;
					if(students[i][j]>students[i][k]+students[k][j]) {
						students[i][j] = students[i][k]+students[k][j];

					}
				}
			}
		}
		// 키 몇등인지 확인
		int answer = 0;
		for(int i=0;i<N;i++) {
			int cnt = 0;
			for(int j=0;j<N;j++) {
				if(i==j)continue;
				if(students[i][j]<INF ||students[j][i]<INF)cnt++;
			}
			if(cnt==N-1)answer++;
		}
		System.out.println(answer);
	}

}
