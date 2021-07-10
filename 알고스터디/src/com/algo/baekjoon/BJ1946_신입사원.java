package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ1946_신입사원 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		for (int t = 1; t <= TC; t++) {
			int N = Integer.parseInt(in.readLine());

			int[][] emp = new int[N][2];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				emp[i][0] = Integer.parseInt(st.nextToken());
				emp[i][1] = Integer.parseInt(st.nextToken());

			}
			Arrays.sort(emp,new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {				
					return o1[1]-o2[1];
				}
				
			});
			int resume = emp[0][0];
			int result = 1;
			for (int i = 0; i < N; i++) {
				if(resume>emp[i][0]) {
					result++;
					resume = emp[i][0];
				}
			}
			System.out.println(result);
		}
	}

}
