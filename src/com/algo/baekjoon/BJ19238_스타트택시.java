package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ19238_스타트택시 {

	static class Node implements Comparable<Node> {
		int r;
		int c;
		int dis;

		public Node(int r, int c, int dis) {
			super();
			this.r = r;
			this.c = c;
			this.dis = dis;
		}

		@Override
		public int compareTo(Node o) {
			if (this.dis == o.dis) {
				if (this.r == o.r) {
					return this.c - o.c;
				} else {
					return this.r - o.r;
				}
			} else {
				return this.dis - o.dis;
			}
		}
	}

	static int N, M, L;
	static int[][] map;
	static int[][] dest;
	static boolean[] person;
	static int startX;
	static int startY;
	static int remainCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		person = new boolean[M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(in.readLine());
		startX = Integer.parseInt(st.nextToken());
		startY = Integer.parseInt(st.nextToken());
		dest = new int[M + 1][2];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			map[x][y] = -i;
			dest[i][0] = x1;
			dest[i][1] = y1;
		}
//		for (int[] b : map) {
//			for (int a : b)
//				System.out.print(a + " ");
//			System.out.println();
//		}

		// 제일 가까운 손님 찾기
		remainCnt = M;
		while (remainCnt != 0) {
//			System.out.println("시작위치 : " + startX + " " + startY);
			Node node = searchCusmoter(startX, startY, L, remainCnt).peek();
			L -= node.dis;
//			System.out.println("사람 위치 : "+node.r+" "+node.c+" 남은 연료 : "+L);
			int[] start = searchDestination(node.r, node.c, L);
			if(start == null) {
				System.out.println(-1);
				System.exit(0);
			}
			startX = start[0];
			startY = start[1];
		}
		System.out.println(L);

	}

	private static int[] searchDestination(int r, int c, int l) {
//		System.out.println("처음 연료 : "+l);
		int[] dr = { 0, -1, 1, 0, 0 };
		int[] dc = { 0, 0, 0, -1, 1 };
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { r, c, 0, l });
		boolean[][] mapVisited = new boolean[N + 1][N + 1];
		int number = -map[r][c];
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int dis = q.peek()[2];
			int remainL = q.poll()[3];
			if (remainL < 0) {
				System.out.println(-1);
				System.exit(0);
			}
			// 도착지 찾기
			if (x == dest[number][0] && y == dest[number][1]) {
				remainL += dis * 2;
				map[r][c] = 0;
				L = remainL;
//				System.out.println("남은 연료 : " + remainL);
//				System.out.println("도착위치 : " + x + " " + y);
				remainCnt--;
				return new int[] { x, y };
			}

			for (int i = 0; i < 5; i++) {
				int nx = x + dr[i];
				int ny = y + dc[i];

				if (nx >= 1 && nx <= N && ny >= 1 && ny <= N && map[nx][ny] != 1 && !mapVisited[nx][ny]) {
					mapVisited[nx][ny] = true;
					q.offer(new int[] { nx, ny, dis + 1, remainL - 1 });
				}
			}

		}
		return null;
	}

	private static PriorityQueue<Node> searchCusmoter(int startX, int startY, int l, int m) {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		boolean[] visited = new boolean[M + 1];
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] mapVisited = new boolean[N + 1][N + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		q.offer(new int[] { startX, startY, 0, l });
		int personCnt = 0;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			// 사람 찾음
			if (map[now[0]][now[1]] < 0 && !visited[-map[now[0]][now[1]]]) {
				personCnt++;
				visited[-map[now[0]][now[1]]] = true;
//				System.out.println(now[0] + " " + now[1]);
				pq.offer(new Node(now[0], now[1], now[2]));
			}
			if (personCnt == m)
				break;
			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dr[i];
				int ny = now[1] + dc[i];
				if (nx >= 1 && nx <= N && ny >= 1 && ny <= N && map[nx][ny] != 1 && !mapVisited[nx][ny]) {
					if (l > 0) {
//						System.out.println(nx+" "+ny);
						mapVisited[nx][ny] = true;
						q.offer(new int[] { nx, ny, now[2] + 1, l - 1 });
					}
				}
			}
		}
		if (personCnt != m) {
//			System.out.println("여기로?");
			System.out.println(-1);
			System.exit(0);
		}
		return pq;
	}
}




