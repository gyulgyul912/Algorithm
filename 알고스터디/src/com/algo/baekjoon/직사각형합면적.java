package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 직사각형합면적 {

	public static void main(String[] args) throws IOException, NumberFormatException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;
		boolean[][] map = new boolean[101][101];
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			String[] str = in.readLine().split(" ");
			x1 = Integer.parseInt(str[0]);
			y1 = Integer.parseInt(str[1]);
			x2 = Integer.parseInt(str[2]);
			y2 = Integer.parseInt(str[3]);
			for (int a = x1; a < x2; a++) {
				for (int b = y1; b < y2; b++) {
					if (!map[a][b])
						map[a][b] = true;
				}
			}
		}
		for (int k = 1; k <=100; k++) {
			for (int j = 1; j <= 100; j++) {
				if (map[k][j])
					cnt++;
			}
		}
		System.out.println(cnt);
	}

}
