package com.algo.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 파이프연결 {
	static int minDis;
	static int N;
	static int[][] area;
	static int[][] minPipe;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int t = 1; t <= TC; t++) {
			minDis = Integer.MAX_VALUE;
			N = Integer.parseInt(in.readLine());
			area = new int[N][N];
			minPipe = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(minPipe[i], Integer.MAX_VALUE);
			}
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					area[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			canConnect(0, 0);

			sb.append("#").append(t).append(" ").append(minPipe[N - 1][N - 1]).append(" ");
		}
		System.out.println(sb.toString());
	}

	private static void canConnect(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();

		if (area[r][c] == 1 || area[r][c] == 2) {
			q.add(new int[] { r, c, 3 });
		} else {
			q.add(new int[] { r, c, 1 });
		}
		minPipe[r][c] = 1;
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int outDir = q.poll()[2];
			System.out.println("현재 : " + x + " " + y + " " + outDir);
			if (x == N - 1 && y == N - 1 && outDir == 2)
				return;

			int nx = x + dr[outDir];
			int ny = y + dc[outDir];
			if (nx >= 0 && nx < N && ny >= 0 && ny < N && area[nx][ny] != 0 && minPipe[nx][ny] > minPipe[x][y] + 1) {
				int pipe = area[nx][ny];
				System.out.println("파이프" + pipe + "설치 가능");
				if (pipe == 1 || pipe == 2) { // 직선 파이프
					// 설치할 파이프의 나오는 쪽 연결 가능한 곳인지 확인
					int nnx = nx + dr[outDir];
					int nny = ny + dc[outDir];
					if (nnx >= 0 && nnx < N && nny >= 0 && nny < N && area[nnx][nny] != 0) {
						q.add(new int[] { nx, ny, outDir });
						minPipe[nx][ny] = minPipe[x][y] + 1;
					}
					if (nnx == N - 1 && nny == N - 1) {
						minPipe[nx][ny] = minPipe[x][y] + 2;
						break;
					}

				} else { // 굽어진 파이프
					if (outDir == 0 || outDir == 1) { // 나오는 방향이 아래나 위일 때
						// 오른쪽 왼쪽 둘중 하나로 뚫어야함
						int nnx = nx + dr[2];
						int nny = ny + dc[2];
						System.out.println(nx+" "+ny);
						System.out.println("파이프 뚤림? : "+nnx+" "+nny);
						if (nnx >= 0 && nnx < N && nny >= 0 && nny < N && area[nnx][nny] != 0) {
							q.add(new int[] { nx, ny, 2 });
							minPipe[nx][ny] = minPipe[x][y] + 1;
						}
						if (nnx == N - 1 && nny == N - 1) {
							minPipe[nx][ny] = minPipe[x][y] + 2;
							break;
						}
						nnx = nx + dr[3];
						nny = ny + dc[3];
						System.out.println(nx+" "+ny);
						System.out.println("파이프 뚤림? : "+nnx+" "+nny);
						if (nnx >= 0 && nnx < N && nny >= 0 && nny < N && area[nnx][nny] != 0) {
							q.add(new int[] { nx, ny, 3 });
							minPipe[nx][ny] = minPipe[x][y] + 1;
						}
						if (nnx == N - 1 && nny == N - 1) {
							minPipe[nnx][nny] = minPipe[x][y] + 2;
							break;
						}

					} else {
						int nnx = nx + dr[0];
						int nny = ny + dc[0];
						if (nnx >= 0 && nnx < N && nny >= 0 && nny < N && area[nnx][nny] != 0) {
							q.add(new int[] { nx, ny, 0 });
							minPipe[nx][ny] = minPipe[x][y] + 1;
						}
						if (nnx == N - 1 && nny == N - 1) {
							minPipe[nx][ny] = minPipe[x][y] + 2;
							break;
						}
						nnx = nx + dr[1];
						nny = ny + dc[1];
						if (nnx >= 0 && nnx < N && nny >= 0 && nny < N && area[nnx][nny] != 0) {
							q.add(new int[] { nx, ny, 1 });
							minPipe[nx][ny] = minPipe[x][y] + 2;
						}
						if (nnx == N - 1 && nny == N - 1) {
							minPipe[nx][ny] = minPipe[x][y] + 2;
							break;
						}

					}
				}
			}
		}
	}
}
