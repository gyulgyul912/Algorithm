package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 캐슬디펜스 {
	static int N;
	static int M;
	static int D;
	static int[][] map;
	static int[] arrow;
	static int killCnt;
	static int Max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException, NumberFormatException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		// 맵 만들기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 궁수 배치
		arrow = new int[3];
		combination(0, 0);		
		System.out.println(Max);
	}
	private static void combination(int cnt, int start) {
		if (cnt == 3) {
			killEnemy(arrow);
			return;
		}
		for (int i = start; i < M; i++) {
			arrow[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}
	private static void killEnemy(int[] arrow2) {
		// 쏴 죽이기

		int loc = N;			// 궁수 위치
		boolean[][] flags = new boolean[N][M];	// 죽은 적 표시
		killCnt = 0;

		for (int i = N - 1; i >= 0; i--) {
			// 적과 얼마나 떨어져 있는지 i+k
			int k = 0;
			boolean[] flag = new boolean[3]; // 한번 공격에 2번 쏘지 않도록
			// 공격 거리 제한 내 적들 kill
			while (k < D) {		
				for (int j = 0; j < M; j++) {
					if (i - k >= 0 && map[i - k][j] == 1) {
						for (int a = 0; a < arrow2.length; a++) {
							if (!flag[a] && Math.abs(i - k - loc) + Math.abs(j - arrow2[a]) <= D) {
								if(!flags[i-k][j]) {
									killCnt++;
								}
								flags[i-k][j] = true;
								flag[a] = true;

								//break;
							}
						}
					}
				}			
				k++;
			}
			loc--;
		}
		if (Max < killCnt) {
			Max = killCnt;
		}
	}

}
