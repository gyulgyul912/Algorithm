package com.algo.programmers;

import java.util.Arrays;

public class 정수삼각형 {

	public static void main(String[] args) {

		int[][] triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		System.out.println(Solution(triangle));

	}

	private static int Solution(int[][] triangle) {
		int answer = 0;
		for (int i = 1; i < triangle.length; i++) {
			int len = triangle[i].length;
			
			for (int j = 0; j < len; j++) {
				if (j == 0) {
					triangle[i][j] = triangle[i][j] + triangle[i - 1][0];
				} else if (j == (len - 1)) {
					triangle[i][j] = triangle[i][j] + triangle[i - 1][triangle[i - 1].length - 1];
				} else {
					triangle[i][j] = triangle[i][j] + Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
				}
				if (i == (triangle.length - 1)) {
					answer = Math.max(triangle[i][j], answer);
				}
			}

		}
		return answer;
	}

}
