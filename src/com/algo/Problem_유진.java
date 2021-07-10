package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_유진 {

	static final int INF = 1000000000;
	static int N;
	static int[][] map;
	static Fish shark;
	static int eat;
	static List<Fish> fishes;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(in.readLine());
		for (int k = 1; k <= T; k++) {
			N = Integer.parseInt(in.readLine());

			map = new int[N][N];
			fishes = new ArrayList<Fish>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

					if (map[i][j] >= 1 && map[i][j] <= 10000000) {
						fishes.add(new Fish(i, j, map[i][j], INF));
					} else if (map[i][j] == -1) {
						shark = new Fish(i, j, 10, 0);
					}
				}
			}

			int second = 0;

			while (true) {
				// 먹을 수 있는 물고기가 있는지 확인한다.
				// bfs로 거리를 체크한다.
				Fish fish = isAvailable();
				if (fish == null)
					break;

//         System.out.println(fish + "를 먹을거야");

				second += fish.d; // 거리만큼 초가 걸린다.
				eat++; // 먹었다

				// 힘이 세졌다. size가 힘이다.
				shark.size += fish.size;

				map[fish.x][fish.y] = 0; // 먹었으니까 없애줬다.

				shark.x = fish.x;
				shark.y = fish.y; // 상어의 위치는 이제 물고기의 위치가 된다.

			}

			System.out.println("#"+k+" "+second + " " + shark.size);
		}

	}

	private static Fish isAvailable() {
		Fish fish = null;
		Queue<int[]> q = new LinkedList<int[]>();
		PriorityQueue<Fish> pq = new PriorityQueue<Fish>();
		boolean[][] visited = new boolean[N][N];

		q.offer(new int[] { shark.x, shark.y, 0 });
		visited[shark.x][shark.y] = true;
		map[shark.x][shark.y] = 0;

		while (!q.isEmpty()) {

			int size = q.size();

			for (int k = 0; k < size; k++) {
				int[] pos = q.poll();
				int x = pos[0];
				int y = pos[1];
				int s = pos[2];

//            System.out.println(Arrays.toString(pos) + "에서 간다");
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					int ns = s + 1;

					if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && shark.size >= map[nx][ny]) {
						visited[nx][ny] = true;

						if (map[nx][ny] == 0 || map[nx][ny] == shark.size) {
							q.offer(new int[] { nx, ny, ns });
						} else if (map[nx][ny] < shark.size) {
							pq.offer(new Fish(nx, ny, map[nx][ny], ns));
						}
					}
				}
			}

//         System.out.println(pq);
			if (!pq.isEmpty()) {
				fish = pq.poll();
				break;
			}
		}
		return fish;
	}

	static class Fish implements Comparable<Fish> {
		int x;
		int y;
		long size;
		int d;

		public Fish(int x, int y, long size, int d) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
			this.d = d;
		}

		public void setD(int d) {
			this.d = d;
		}

		@Override
		public String toString() {
			return "Fish [x=" + x + ", y=" + y + ", size=" + size + ", d=" + d + "]";
		}

		@Override
		public int compareTo(Fish o) {
			if (this.d == o.d) {
				if (this.x == o.x) {
					return this.y - o.y;
				}
				return this.x - o.x;
			}
			return this.d - o.d;
		}

	}
}
