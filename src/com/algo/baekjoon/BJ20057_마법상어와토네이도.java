package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ20057_마법상어와토네이도 {
	static int outSand;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] str = in.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		int[][] dlt = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
		// 시작
		int r = N / 2;
		int c = N / 2;
		int k = 1;
		System.out.println(r + " " + c);
		while (true) {
			for (int i = 0; i < 4; i++) {
				if (i == 2)
					k++;
				for (int j = 1; j <= k; j++) {
					r += dlt[i][0];
					c += dlt[i][1];
					// 모래가 있으면
					if (map[r][c] != 0) {
						outSand += spreadSand(i, r, c);
					}
				}
			}
			k++;
			if (r == 0 && c == N - 1) {
				// 마지막 줄
				for (int i = c; i >= 1; i--) {
					c--;
				}
				break;
			}

		}

	}

	private static int spreadSand(int i, int r, int c) {
		switch (i) {
		case 0:
			int[][] dlt1 = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
			int[][] dlt2 = { { 0, -2 }, { -2, 0 }, { 2, 0 } };
			break;
		case 1:
//			int[][] dlt1 = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
//			int[][] dlt2 = { { 0, -2 }, { -2, 0 }, { 2, 0 } };
			break;
		case 2:
//			int[][] dlt1 = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
//			int[][] dlt2 = { { 0, -2 }, { -2, 0 }, { 2, 0 } };
			break;
		case 3:
//			int[][] dlt1 = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
//			int[][] dlt2 = { { 0, -2 }, { -2, 0 }, { 2, 0 } };
			break;
		}
		return outSand;

	}

}
