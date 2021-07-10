package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ17069_파이프옮기기_TopDown {
	static int N;
	static int[][] house;
	static int garo = 0;
	static int sero = 1;
	static int daegak = 2;
	static int ans = 0;

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
		topDown(1, 2, garo);
		System.out.println(ans);
	}

	private static void topDown(int x, int y, int dir) {
		if (x == N && y == N) {
			ans++;
			return;
		}

		if (dir == garo && y + 1 <= N && house[x][y + 1] == 0) {
			topDown(x, y + 1, dir);
		} else if (dir == sero && x + 1 <= N && house[x + 1][y] == 0) {
			topDown(x + 1, y, dir);

		} else if (dir == daegak) {
			if (y + 1 <= N && house[x][y + 1] == 0)
				topDown(x, y + 1, garo);
			if (x + 1 <= N && house[x + 1][1] == 0)
				topDown(x + 1, y, sero);
		}
		if (x + 1 <= N && y + 1 <= N && house[x + 1][y] == 0 && house[x][y + 1] == 0 && house[x + 1][y + 1] == 0)
			topDown(x + 1, y + 1, daegak);
	}
	
}
