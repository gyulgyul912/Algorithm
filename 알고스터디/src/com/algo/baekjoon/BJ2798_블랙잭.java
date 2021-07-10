package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2798_블랙잭 {
	static int N, M;
	static int[] cards;
	static boolean[] visited;
	static int sumMax;
	static int disMin;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cards = new int[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		visited = new boolean[N];
		int[] selected = new int[3];
		sumMax = Integer.MIN_VALUE;
		disMin = Integer.MAX_VALUE;
		permutation(0, 0);
		System.out.println(sumMax);

	}

	private static void permutation(int cnt, int sum) {

		if (sum > M)
			return;
		if (cnt == 3) {
			int distance = M-sum;
			if(disMin> distance) {
				disMin = distance;
				sumMax = sum;
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			permutation(cnt + 1, sum + cards[i]);
			visited[i] = false;
		}

	}

}
