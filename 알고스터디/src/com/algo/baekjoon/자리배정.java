package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 자리배정 {
	static int R;
	static int C;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int k;
	static int[][] map;

	public static void main(String[] args) throws IOException, NumberFormatException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] str = in.readLine().split(" ");
		R = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		k = Integer.parseInt(in.readLine());
		map = new int[R + 1][C + 1];
		int cnt = 1;
		int sx = 1;
		int sy = 1;
		map[1][1] = 1;
		recurvise(sx, sy, cnt);
	}

	private static void recurvise(int sx, int sy, int cnt) {
		if (k > R * C) {
			System.out.println(0);
			return;
		}
		for(int d = 0;d<4;) {
			while (true) {
				if (cnt == k) {
					System.out.println(sx + " " + sy);
					return;
				}
				sx += dr[d];
				sy += dc[d];
				if (!(1 <= sx && sx <= R && 1 <= sy && sy <= C) || map[sx][sy] == 1) {
					sx -= dr[d];
					sy -= dc[d];
					d++;
					break;
				}
				map[sx][sy] = 1;
				cnt++;
			}
		}
		recurvise(sx, sy, cnt);
	}
}
