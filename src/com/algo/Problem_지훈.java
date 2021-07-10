package com.algo;

import java.io.*;
import java.util.*;

public class Problem_지훈 {

	static int N;
	static long[][] map;
	static boolean[][] visit;
	static int size = 2;
	static int jihunR, jihunC;
	static int resTime;
	static long resPower;
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, -1, 0, 1 }; // 위 왼 아래 오른

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int k = 0; k < 10; k++) {
			N = Integer.parseInt(br.readLine());
			map = new long[N][N];
			visit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					long temp = Long.parseLong(st.nextToken());
					map[i][j] = temp;
					if (temp == -1) {
						jihunR = i;
						jihunC = j;
					}

				}
			}
			resTime = 0;
			resPower = 10;
			while (jihunR != -1) {
				map[jihunR][jihunC] = resPower;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						visit[i][j] = false;
					}
				}
				bfs(jihunR, jihunC);
			}
			System.out.println(resTime + " " + resPower);
		}
	}

	public static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { r, c, 0 });
		map[r][c] = 0; // 지훈이가 이동할 것이므로 0으로 미리 세팅
		int check = Integer.MAX_VALUE;
		ArrayList<int[]> list = new ArrayList<>();
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			if (temp[2] == check)
				break;
			for (int i = 0; i < 4; i++) {
				int nr = temp[0] + dr[i];
				int nc = temp[1] + dc[i];

				if (nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;
				if (!visit[nr][nc] && map[nr][nc] != 0 && map[nr][nc] < resPower) {
					check = temp[2] + 1;
					list.add(new int[] { nr, nc });
				}

				if (!visit[nr][nc] && map[nr][nc] <= resPower) {
					q.offer(new int[] { nr, nc, temp[2] + 1 });
					visit[nr][nc] = true;
				}

			}
		}
		if (list.size() != 0) {
			int minR = Integer.MAX_VALUE;
			int minC = Integer.MAX_VALUE;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i)[0] < minR) {
					minR = list.get(i)[0];
					minC = list.get(i)[1];
				}
				if (list.get(i)[0] == minR && list.get(i)[1] < minC) {
					minR = list.get(i)[0];
					minC = list.get(i)[1];
				}
			}
			resTime += check;
			resPower += map[minR][minC];
			jihunR = minR;
			jihunC = minC;
		} else {
			jihunR = -1;
			jihunC = -1;
		}
	}
}
