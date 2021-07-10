package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ14442_벽부수고이동하기2 {
	static int N, M, K;
	static int[][] map;
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] str = in.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		visited = new boolean[N][M][K + 1];
		visited[0][0][0] = true;
		bfs(0, 0);
	}

	static public class Node {
		int x;
		int y;
		int move;
		int punch;

		public Node(int x, int y, int move, int punch) {
			super();
			this.x = x;
			this.y = y;
			this.move = move;
			this.punch = punch;
		}
	}

	private static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<Node>();
		int[][] dlt = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		q.offer(new Node(x, y, 1, 0)); // 처음 시작
		while (!q.isEmpty()) {
			Node n = q.poll();
			System.out.println(n.x + " " + n.y + " " + n.move + " " + n.punch);
			if (n.x == N - 1 && n.y == M - 1) { // 끝에 도달하면 출력
				System.out.println(n.move);
				return;
			}
			for (int i = 0; i < 4; i++) { // 4방 탐색
				int nx = n.x + dlt[i][0];
				int ny = n.y + dlt[i][1];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (map[nx][ny] == 1 && n.punch + 1 <= K && !visited[nx][ny][n.punch + 1]) {
						q.offer(new Node(nx, ny, n.move + 1, n.punch + 1));

						visited[nx][ny][n.punch + 1] = true;
//						visited[n.x][n.y][n.punch + 1] = true;
						System.out.println("벽을 부순 : " + nx + " " + ny);
					}
					if (map[nx][ny] != 1 && !visited[nx][ny][n.punch]) {
						q.offer(new Node(nx, ny, n.move + 1, n.punch));
						visited[nx][ny][n.punch] = true;
						System.out.println("그냥 간 : " + nx + " " + ny);
					}
				}
			}
		}
		System.out.println(-1);
	}
}
