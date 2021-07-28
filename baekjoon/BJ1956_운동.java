package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1956_운동 {
	static final int INF = 987654321;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int[][] map = new int[v+1][v+1];
		for(int i=1;i<=v;i++) {
			Arrays.fill(map[i], INF);
			map[i][i] = 0;
		}
		for(int i=0;i<e;i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[from][to] = Integer.parseInt(st.nextToken());
		}
		for(int k=1;k<=v;k++) {
			for(int i=1;i<=v;i++) {
				for(int j=1;j<=v;j++) {
					if(i==j||k==i||k==j)continue;
					if(map[i][j]>map[i][k]+map[k][j])
						map[i][j] = map[i][k]+map[k][j];
				}
			}
		}
		int min = INF;
		for(int i=1;i<=v;i++) {
			for(int j=1;j<=v;j++) {
				if(i==j)continue;
				if(map[i][j]!=INF && map[j][i]!=INF)
					min = Math.min(min, map[i][j]+map[j][i]);
			}
		}
		if(min==INF)System.out.println(-1);
		else
		System.out.println(min);
	}

}
