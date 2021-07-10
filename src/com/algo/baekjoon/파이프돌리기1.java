package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 파이프돌리기1 {
	static int N;
	static boolean[][] visited;
	static int[][] house;
	static int[][] dlt = { { 0, 1 }, { 1, 1 }, { 1, 0 } };
	static int cnt;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		house = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String[] str = in.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				house[i][j] = Integer.parseInt(str[j]);
			}
		}
		cnt=0;
		recursive(0, 1, 1);
		System.out.println(cnt);
	}

	private static void recursive(int x, int y, int c) {
		
		// 경계 벗어나거나 벽이 있을 경우
		if(x>=N || y>=N || house[x][y]==1) {
			return;
		}
		// 대각선
		if(c==2 && (house[x-1][y]==1 || house[x][y-1]==1)) {
			return;
		}
		if(x==N-1 && y==N-1) {
			cnt++;
			return;
		}

		
		if (c == 1) { // 가로
			for (int i = 0; i < 2; i++) { // 왼쪽 , 대각선
				recursive(x + dlt[i][0], y + dlt[i][1], i + 1);
			}
		} else if (c == 2) { // 대각선
			for (int i = 0; i < 3; i++) { // 왼쪽 , 대각선 , 아래
				recursive(x + dlt[i][0], y + dlt[i][1], i + 1);
			}
		} else if (c == 3) { // 세로
			for (int i = 1; i < 3; i++) { // 대각선 , 아래
				recursive(x+dlt[i][0], y+dlt[i][1], i + 1);
			}
		}
	}

}
