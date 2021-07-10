package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이 {

	public static void main(String[] args) throws IOException, NumberFormatException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int numOfPaper = Integer.parseInt(in.readLine());

		boolean[][] area = new boolean[101][101];
		
		int areaCnt = 0;
		for (int k = 0; k < numOfPaper; k++) {

			String[] str = in.readLine().split(" ");

			// 왼쪽 아래쪽 과의 거리
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);

			for (int i = x; i <= x + 9; i++) {
				for (int j = y; j <= y + 9; j++) {
					// 넓이에 포함되어 있지 않으면 true로 변경
					if (!area[i][j]) {

						area[i][j] = true;
						areaCnt+=1;

					}
				}
			}


		}
		
		System.out.println(areaCnt);
	}

}







