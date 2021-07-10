package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주사위쌓기 {

	public static void main(String[] args) throws IOException, NumberFormatException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(in.readLine());

		int min = Integer.MAX_VALUE;
		int[][] dice = new int[n][6];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int up = 0;
		int down = 0;
		// 여섯면 다 확인
		int totSum = Integer.MIN_VALUE;
		for (int j = 0; j < 6; j++) {
			int total = 0;
			if (j == 0) {
				up = dice[0][j + 5];
				down = dice[0][j];

			} else if (j == 1 || j == 2) {
				up = dice[0][j + 2];
				down = dice[0][j];

			} else if (j == 3 || j == 4) {
				up = dice[0][j - 2];
				down = dice[0][j];
			} else if (j == 5) {
				up = dice[0][j - 5];
				down = dice[0][j];
			}

			// 위랑 아래 아닌 것 중 max 찾기

			int max = 0;
			for (int k = 6; k >= 1; k--) {
				if (k != up && k != down) {
					max = k;
					break;
				}
			}
			total += max;

			// 밑에꺼 윗면 과 위의 아랫면 매칭

			for (int i = 1; i < n; i++) {
				// 아래 윗면과 위의 아랫면 같은 것 찾기
				for (int k = 0; k < 6; k++) {
					if (dice[i][k] == up) {
						down = up;
						if (k == 0) {
							up = dice[i][k + 5];
						} else if (k == 1 || k == 2) {
							up = dice[i][k + 2];
						} else if (k == 3 || k == 4) {
							up = dice[i][k - 2];
						} else if (k == 5) {
							up = dice[i][k - 5];
						}
						break;
					}
				}

				// 하... 이제 찾자 max
				max = 0;
				for (int k = 6; k >= 1; k--) {
					if (k != up && k != down) {
						max = k;
						break;
					}
				}
				total += max;
				
			}
			// 여섯개 중 제일 최대 찾기...ㅜ 어렵
			if (totSum < total) {
				totSum = total;
			}
		}
		System.out.println(totSum);
	}

}
