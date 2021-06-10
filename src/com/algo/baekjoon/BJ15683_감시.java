package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ15683_감시 {
	static int N, M;
	static int[][] map;
	static int cctvNum;
	static int[][] cctv;
	static int minSagakSum;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] str = in.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		map = new int[N][M];
		cctv = new int[10][2];
		cctvNum = 0;
		int sagakSum = 0;
		for (int i = 0; i < N; i++) {
			str = in.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				if (map[i][j] != 0 && map[i][j] != 6) {
					cctv[cctvNum][0] = i;
					cctv[cctvNum][1] = j;
					cctvNum++;
				}
				if (map[i][j] == 0)
					sagakSum++;
			}
		}

		int[][] copy = copyMap(map);
		minSagakSum = Integer.MAX_VALUE;
//		System.out.println("cctv 개수 : "+cctvNum);

//		System.out.println("처음 개수 : "+sagakSum);
		searchSagak(cctv[0][0], cctv[0][1], 0, sagakSum, copy);
		System.out.println(minSagakSum);
	}

	private static int[][] copyMap(int[][] nowMap) {
		int[][] newMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newMap[i][j] = nowMap[i][j];
			}
		}
		return newMap;
	}

	private static void searchSagak(int r, int c, int cnt, int sagakSum, int[][] nowMap) {
//		System.out.println(sagakSum);
//		System.out.println("ctv 개수 : "+cnt);
//		System.out.println("시작 지점 : "+r+ " "+c);
		if (cnt == cctvNum) {
			minSagakSum = Math.min(sagakSum, minSagakSum);
			return;
		}
//		System.out.println("현재 위치 cctv : "+map[r][c]);
		switch (map[r][c]) {
		case 1: {
			int[] dr = { -1, 1, 0, 0 };
			int[] dc = { 0, 0, -1, 1 };

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				int nowSagakSum = sagakSum;
				int[][] copy = copyMap(nowMap);
				nowSagakSum = removeSagak(nr, nc, nowSagakSum, copy, dr, dc, i);
				searchSagak(cctv[cnt + 1][0], cctv[cnt + 1][1], cnt + 1, nowSagakSum, copy);
			}
			break;
		}
		case 2: {
			int[] dr = { -1, 1, 0, 0 };
			int[] dc = { 0, 0, -1, 1 };
			int nowSagakSum = sagakSum;
			int[][] copy = copyMap(nowMap);
			for (int i = 0; i < 2; i++) {
				nowSagakSum = removeSagak(r + dr[i], c + dc[i], nowSagakSum, copy, dr, dc, i);
			}
//			System.out.println(nowSagakSum);
			searchSagak(cctv[cnt + 1][0], cctv[cnt + 1][1], cnt + 1, nowSagakSum, copy);

			nowSagakSum = sagakSum;
			copy = copyMap(nowMap);
			for (int i = 2; i < 4; i++) {
				nowSagakSum = removeSagak(r + dr[i], c + dc[i], nowSagakSum, copy, dr, dc, i);
			}
			searchSagak(cctv[cnt + 1][0], cctv[cnt + 1][1], cnt + 1, nowSagakSum, copy);
			break;
		}
		case 3: {
			int[] dr = { -1, 0, 1, 0 };
			int[] dc = { 0, 1, 0, -1 };
			int nowSagakSum = sagakSum;
			int[][] copy = copyMap(nowMap);
			for (int i = 0; i < 2; i++) {
				nowSagakSum = removeSagak(r + dr[i], c + dc[i], nowSagakSum, copy, dr, dc, i);
			}
			searchSagak(cctv[cnt + 1][0], cctv[cnt + 1][1], cnt + 1, nowSagakSum, copy);

			nowSagakSum = sagakSum;
			copy = copyMap(nowMap);
			for (int i = 1; i < 3; i++) {
				nowSagakSum = removeSagak(r + dr[i], c + dc[i], nowSagakSum, copy, dr, dc, i);
			}
			searchSagak(cctv[cnt + 1][0], cctv[cnt + 1][1], cnt + 1, nowSagakSum, copy);

			nowSagakSum = sagakSum;
			copy = copyMap(nowMap);
			for (int i = 2; i < 4; i++) {
				nowSagakSum = removeSagak(r + dr[i], c + dc[i], nowSagakSum, copy, dr, dc, i);
			}
			searchSagak(cctv[cnt + 1][0], cctv[cnt + 1][1], cnt + 1, nowSagakSum, copy);

			nowSagakSum = sagakSum;
			copy = copyMap(nowMap);
			for (int i = 0; i <= 3; i += 3) {
				nowSagakSum = removeSagak(r + dr[i], c + dc[i], nowSagakSum, copy, dr, dc, i);
			}
			searchSagak(cctv[cnt + 1][0], cctv[cnt + 1][1], cnt + 1, nowSagakSum, copy);
			break;
		}
		case 4: {
			int[] dr = { 0, -1, 0, 1 };
			int[] dc = { -1, 0, 1, 0 };
			int nowSagakSum = sagakSum;
			int[][] copy = copyMap(nowMap);
			for (int i = 0; i < 3; i++) {
				nowSagakSum = removeSagak(r + dr[i], c + dc[i], nowSagakSum, copy, dr, dc, i);
			}
			searchSagak(cctv[cnt + 1][0], cctv[cnt + 1][1], cnt + 1, nowSagakSum, copy);

			nowSagakSum = sagakSum;
			copy = copyMap(nowMap);
			for (int i = 1; i < 4; i++) {
				nowSagakSum = removeSagak(r + dr[i], c + dc[i], nowSagakSum, copy, dr, dc, i);
			}
			searchSagak(cctv[cnt + 1][0], cctv[cnt + 1][1], cnt + 1, nowSagakSum, copy);

			nowSagakSum = sagakSum;
			copy = copyMap(nowMap);
			for (int i = 2; i <= 4; i++) {
				if (i == 4)
					i = 0;
				nowSagakSum = removeSagak(r + dr[i], c + dc[i], nowSagakSum, copy, dr, dc, i);
				if (i == 0)
					break;
			}
			searchSagak(cctv[cnt + 1][0], cctv[cnt + 1][1], cnt + 1, nowSagakSum, copy);

			nowSagakSum = sagakSum;
			copy = copyMap(nowMap);
			for (int i = 0; i < 4; i++) {
				if (i == 2)
					i = 3;
				nowSagakSum = removeSagak(r + dr[i], c + dc[i], nowSagakSum, copy, dr, dc, i);
				if (i == 3)
					break;
			}
			searchSagak(cctv[cnt + 1][0], cctv[cnt + 1][1], cnt + 1, nowSagakSum, copy);
			break;
		}
		case 5: {
			int[] dr = { 0, -1, 0, 1 };
			int[] dc = { -1, 0, 1, 0 };
			int nowSagakSum = sagakSum;
			int[][] copy = copyMap(nowMap);
			for (int i = 0; i < 4; i++) {
				nowSagakSum = removeSagak(r + dr[i], c + dc[i], nowSagakSum, copy, dr, dc, i);
			}
//			System.out.println("남은 사각지대 개수 : "+nowSagakSum);
			searchSagak(cctv[cnt + 1][0], cctv[cnt + 1][1], cnt + 1, nowSagakSum, copy);
			break;
		}

		}

	}

	private static int removeSagak(int nr, int nc, int nowSagakSum, int[][] copy, int[] dr, int[] dc, int i) {
		while (checkOk(nr, nc, copy)) {
			if (copy[nr][nc] == 0) {
				copy[nr][nc] = -1;
				nowSagakSum--;
				nr += dr[i];
				nc += dc[i];
			} else if (copy[nr][nc] == 6) {
				break;
			} else {
				nr += dr[i];
				nc += dc[i];
			}
		}
		return nowSagakSum;
	}

	private static boolean checkOk(int nr, int nc, int[][] nowMap) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
			return true;
		}
		return false;
	}
}
