package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 배열돌리기1 {

	static boolean[][] flag;
	static int row, col;
	static int[][] matrix;
	static int turn;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] str = in.readLine().split(" ");
		row = Integer.parseInt(str[0]);
		col = Integer.parseInt(str[1]);
		turn = Integer.parseInt(str[2]);
		matrix = new int[row][col];
		for (int i = 0; i < row; i++) {
			String[] sss = in.readLine().split(" ");
			for (int j = 0; j < col; j++) {
				matrix[i][j] = Integer.parseInt(sss[j]);
			}
		}
		int num = Math.min(row, col) / 2; // 돌릴 개수
		for(int i = 0;i<turn;i++) {
			matrix = Solution(0, 0, num, matrix, 0);
		}
		for(int[] a : matrix) {
			for(int c: a)
				System.out.print(c+" ");
			System.out.println();
		}
	}
	private static int[][] Solution(int sx, int sy, int num, int[][] matrix, int cnt) {
		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		flag = new boolean[row][col];
		// turn 만큼 회전시키면 배열 반환하기
		int[][] newMatrix = new int[row][col];	

		for (int i = 0; i < num; i++) {	// 돌릴 테두리 개수

			int d = 0;
			while (d < 4) { // 한 테두리 한번 회전 구현
				// 경계 벗어나지 않고 방문하지 않았으면 회전
				if (0 <= sx + dr[d] && sx + dr[d] < row && 0 <= sy + dc[d] && sy + dc[d] < col
						&& !flag[sx + dr[d]][sy + dc[d]]) {
					newMatrix[sx + dr[d]][sy + dc[d]] = matrix[sx][sy];
					sx += dr[d];
					sy += dc[d];
					flag[sx ][sy] = true;
					continue;
				}
				d++;
			}
			sx+=1;	// 다음 테두리로 이동
			sy+=1;
		}
		return newMatrix;
	}

}
