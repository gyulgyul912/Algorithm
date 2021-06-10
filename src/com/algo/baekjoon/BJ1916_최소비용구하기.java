package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1916_최소비용구하기 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		StringTokenizer st;
		// 비용이 0인 거 이면 맨 마지막에 0인거 걸릴 수 있음.
		int[][] adj = new int[N+1][N+1];
		for(int i=0;i<M;i++) {
			st  = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adj[start][end] = cost;
		}
		st  = new StringTokenizer(in.readLine());
		int startPoint = Integer.parseInt(st.nextToken());
		int endPoint = Integer.parseInt(st.nextToken());
		
		int[] costs = new int[N+1]; // 출발점에서 각 지점까지의 최소 비용 저장
		boolean[] visited = new boolean[N+1]; // 계산 했는지 확인	
		Arrays.fill(costs, Integer.MAX_VALUE);
		costs[startPoint] = 0;	
		for(int i=1;i<=N;i++) { // 
			int min = Integer.MAX_VALUE;
			int idx = 0;
			for(int j = 1;j<=N;j++) {
				if(!visited[j] && min >costs[j]) {
					min = costs[j];
					idx = j;
				}
			}
			visited[idx] = true;	
			if(idx==endPoint) break;
			for(int j=1;j<=N;j++) {
				if(!visited[j] && adj[idx][j]!=0 && costs[j]>min+adj[idx][j]) {
					costs[j] = min+adj[idx][j];
				}
			}	
		}	
		System.out.println(costs[endPoint]);
	}

}
