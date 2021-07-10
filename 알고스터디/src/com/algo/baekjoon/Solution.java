package com.algo.baekjoon;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[] num = new int[9];
		int sum = 0;

		for (int i = 0; i < 9; i++) {
			num[i] = Integer.parseInt(in.readLine());
			sum += num[i];
		}

		sum -= 100;
		// 초과하게 만든 두 놈을 찾는다..... 와.... ㅎ
		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				// 9명의 총 합에서 -100 한 것이 두 명의 합
				if (num[i] + num[j] == sum) {
					for (int k = 0; k < 9; k++) {
						// 다른 두 놈일 때 빼고 출력
						if (k == i || k == j)
							continue;
						System.out.println(num[k]);
					}
					return;
				}
			}
		}

	}
}
