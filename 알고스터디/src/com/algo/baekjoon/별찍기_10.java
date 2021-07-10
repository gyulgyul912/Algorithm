package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// Baekjoon https://www.acmicpc.net/problem/2447
public class 별찍기_10 {
	static int N;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException, NumberFormatException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		char[][] stars = new char[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				stars[i][j] = ' ';
			}
		}
		int size = N;
		recursive(0, 0, stars, size);
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sb.append(stars[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	private static void recursive(int x, int y, char[][] stars, int size) {
		if (size == 1) {
			stars[x][y] ='*';
			return;
		}

		recursive(x,y,stars,size/3);
		recursive(x,y+size/3,stars,size/3);
		recursive(x,y+2*size/3,stars,size/3);

		recursive(x+size/3,y,stars,size/3);
		recursive(x+size/3,y+2*size/3,stars,size/3);
		
		recursive(x+2*size/3,y,stars,size/3);
		recursive(x+2*size/3,y+size/3,stars,size/3);
		recursive(x+2*size/3,y+2*size/3,stars,size/3);
		
	}

}
