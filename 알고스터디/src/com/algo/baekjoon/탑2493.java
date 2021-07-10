package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 탑2493 {

	public static void main(String[] args) throws IOException, NumberFormatException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int numOfTop = Integer.parseInt(in.readLine());

		StringTokenizer st = new StringTokenizer(in.readLine());

		int[] Top = new int[numOfTop];

		for (int i = 0; i < numOfTop; i++) {
			Top[i] = Integer.parseInt(st.nextToken());
		}
		int[] receive = new int[numOfTop];
		receive[0] = 0;
		int cnt = 0;
		int x = 0;
		int current=1;
		for (int i = 1; i < numOfTop; i++) {
			for (int j = i - 1; x >= 0; j--) {
				if (Top[i] < Top[j]) {
					receive[i] = j + 1;
					cnt++;
					break;
				}
				if (cnt == 0) {
					receive[i] = 0;
				}
			}
		}
		
		for (int rec : receive) {
			System.out.print(rec+" ");
		}

	}

}
