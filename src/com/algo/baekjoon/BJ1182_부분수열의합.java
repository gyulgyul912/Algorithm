package com.algo.baekjoon;

import java.util.LinkedList;
import java.util.Scanner;

public class BJ1182_부분수열의합 {
	static int N, S;
	static boolean[] visited;
	static int totalNum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		int[] number = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			number[i] = sc.nextInt();
		}
		searchSub(0, 0, number);
		if (S == 0)
			totalNum--;
		System.out.println(totalNum);
	}

	private static void searchSub(int cnt, int n, int[] number) {
		if (n == N) {
			if (cnt == S)
				totalNum++;
			return;
		}
//		if (cnt == S && n!=0) {
//			totalNum++;
//			return;
//		}
		searchSub(cnt + number[n], n + 1, number);
		searchSub(cnt, n + 1, number);

	}

}
