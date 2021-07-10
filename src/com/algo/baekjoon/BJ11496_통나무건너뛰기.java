package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11496_통나무건너뛰기 {
	static int N;
	static int totalMin;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		StringTokenizer st;
		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(in.readLine());
			int[] tongNa = new int[N];
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				tongNa[i] = Integer.parseInt(st.nextToken());
			}
			totalMin = Integer.MAX_VALUE;
			Arrays.sort(tongNa);
			int r = tongNa[1];
			int l = tongNa[2];
			totalMin = Math.min(tongNa[1]-tongNa[0], tongNa[2]-tongNa[0]);
			for(int i=3;i<N;i++) {		
				if(r>l) {				
				}
			}
			System.out.println(totalMin);
		}
	}
}
