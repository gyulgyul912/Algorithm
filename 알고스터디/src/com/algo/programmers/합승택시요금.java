package com.algo.programmers;

public class 합승택시요금 {
	static int INF = 200 * 100000 + 1;

	public static void main(String[] args) {

		int n = 6;
		int s = 4;
		int a = 6;
		int b = 2;
		int[][] fares = { { 4, 1, 10 }, { 3, 5, 24 }, { 5, 6, 2 }, { 3, 1, 41 }, { 5, 1, 24 }, { 4, 6, 50 },
				{ 2, 4, 66 }, { 2, 3, 22 }, { 1, 6, 25 } };

		System.out.println(solution(n, s, a, b, fares));

	}



	private static int solution(int n, int s, int a, int b, int[][] fares) {
		int answer = Integer.MAX_VALUE;
		int[][] routes = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					continue;
				routes[i][j] = INF;
			}
		}
		int numOfFares = fares.length;
		// 각 경로별 요금
		for (int i = 0; i < numOfFares; i++) {
			routes[fares[i][0]][fares[i][1]] = routes[fares[i][1]][fares[i][0]] = fares[i][2];
		}

		// i -> k -> j 경로와 기존 i -> j 경로를 비교
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					// 현재 경로가 비용이 더 크면 업데이트
					if (routes[i][j] > routes[i][k] + routes[k][j]) {
						routes[i][j] = routes[i][k] + routes[k][j];
					}
				}
			}
		}
		// 어떤 지점를 거쳐서 갔을 때 둘의 택시요금 합이 최소인지 찾기
		for (int i = 1; i <= n; i++) {
			answer = Math.min(answer, routes[s][i] + routes[i][a] + routes[i][b]);
		}
		return answer;
	}

}
