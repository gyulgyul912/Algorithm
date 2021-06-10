package com.algo;

import java.io.*;
import java.util.*;

public class Problem_원선 {

	static int n, time;
	static long power = 10;
	static long[][] map;
	static boolean[][] visited;

	static PriorityQueue<Person> pq = new PriorityQueue<>(new Comparator<Person>() {

		@Override
		public int compare(Person s1, Person s2) {
			if (s1.cnt == s2.cnt) {
				if (s1.x == s2.x)
					return s1.y - s2.y;
				else
					return s1.x - s2.x;
			} else
				return s1.cnt - s2.cnt;
		}

	});

	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };

	static class Person {
		int x, y, cnt;

		Person(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int k = 1; k <= T; k++) {
			n = Integer.parseInt(br.readLine());
			map = new long[n][n];
			visited = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == -1) {
						map[i][j] = 0;
						pq.add(new Person(i, j, 0));
					}
				}
			}

			searchPerson();
			System.out.println("#"+k+" "+time + " " + power);
		}
	}

	static void searchPerson() {
		while (!pq.isEmpty()) {
			Person cur = pq.poll();
			int x = cur.x, y = cur.y, cnt = cur.cnt;

			if (map[x][y] != 0 && map[x][y] < power) {
				power += map[x][y];
				map[x][y] = 0;

				visited = new boolean[n][n];
				pq.clear();

				time = cnt;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny] || map[nx][ny] > power)
					continue;

				pq.add(new Person(nx, ny, cnt + 1));
				visited[nx][ny] = true;
			}
		}
	}

}