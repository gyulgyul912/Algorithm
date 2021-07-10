package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ21508_상어초등학교 {

	static int[][] students;
	static int[][] seats;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		students = new int[N * N + 1][5];
		seats = new int[N + 1][N + 1];
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		for (int k = 1; k <= N * N; k++) {
			String[] str = in.readLine().split(" ");
			students[k][0] = Integer.parseInt(str[0]);
			students[k][1] = Integer.parseInt(str[1]);
			students[k][2] = Integer.parseInt(str[2]);
			students[k][3] = Integer.parseInt(str[3]);
			students[k][4] = Integer.parseInt(str[4]);
			int[] max = new int[3];
			for (int i = 1; i <= N; i++) {
				int j = 1;
				for (; j <= N; j++) {
					if (seats[i][j] == 0) {
						int favoriteCnt = 0;
						for (int d = 0; d < 4; d++) {
							int nr = i + dr[d];
							int nc = j + dc[d];
							if (nr >= 1 && nr <= N && nc >= 1 && nc <= N && (favorite(nr, nc, k))) {
								favoriteCnt++;
							}
							if (favoriteCnt == 4) {
								seats[i][j] = students[k][0];
								break;
							}
							if (max[0] < favoriteCnt) {
								max[0] = favoriteCnt;
								max[1] = i;
								max[2] = j;
							}
						}
						if (favoriteCnt == 4)
							break;
					}
				}
				if (j != N)
					break;
			}

			k++;
		}
	}

	private static boolean favorite(int nr, int nc, int k) {
		if (seats[nr][nc] == students[k][1] || seats[nr][nc] == students[k][2] || seats[nr][nc] == students[k][3]
				|| seats[nr][nc] == students[k][4]) {
			return true;
		}
		return false;
	}

}
