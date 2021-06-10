package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질 {
	static int min;
	static int init;
	static boolean[] visited = new boolean[100001];
	static int young;

	static public class Xy {
		int x;
		int y;

		public Xy(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int subin = Integer.parseInt(st.nextToken());
		young = Integer.parseInt(st.nextToken());

		visited[subin] = true;
		bfs(subin);
		System.out.println(min);

	}

	private static void bfs(int current) {
		Queue<Xy> q = new LinkedList<Xy>();
		int sec = 0;
		q.offer(new Xy(current,sec));

		while (!q.isEmpty()) {
			int nw = q.peek().x;
			sec = q.peek().y;
			q.poll();
			if (nw == young) {
				min = sec;
				break;
			}
			if ((nw - 1)>=0&&(nw - 1) <= 100000 && (nw - 1) >= 0 && !visited[nw - 1]) {
				q.offer(new Xy(nw-1,sec+1));
				visited[nw - 1] = true;
			}if (!visited[nw + 1] && (nw + 1) <= 100000 && (nw + 1) >= 0) {
				q.offer(new Xy(nw+1,sec+1));
				visited[nw + 1] = true;
			}if (!visited[nw * 2] && (nw * 2) <= 100000 && (nw * 2) >= 0) {
				q.offer(new Xy(nw*2,sec+1));
				visited[nw * 2] = true;
			}
//			
//			System.out.println(sec);
		}

	}
}
