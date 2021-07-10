package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ12014_주식 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(in.readLine());

		for (int t = 1; t <= TC; t++) {
			String[] str = in.readLine().split(" ");
			int N = Integer.parseInt(str[0]);
			int K = Integer.parseInt(str[1]);
			str = in.readLine().split(" ");
			int[] stocks = new int[N];
			for (int i = 0; i < N; i++) {
				stocks[i] = Integer.parseInt(str[i]);
			}
			LinkedList<Integer> list = new LinkedList<>();

			list.offer(stocks[0]);
			int i = 1;
			while (list.size() < K && i < N) {

				int idx = list.size() - 1;
				if (list.get(idx) < stocks[i]) {
					list.offer(stocks[i]);

				} else if (list.get(idx) > stocks[i]) {
					for (; idx > 0; idx--) {
						if (list.get(idx - 1) < stocks[i]) {
							list.add(idx, stocks[i]);
							list.remove(idx + 1);
							break;
						}
					}
					if (idx == 0) {
						list.add(idx, stocks[i]);
						list.remove(idx + 1);
					}
				}
				i++;
			}
//			System.out.println(list.toString());
			if (list.size() == K)
				sb.append("Case #").append(t).append("\n").append(1).append("\n");
			else
				sb.append("Case #").append(t).append("\n").append(0).append("\n");
		}
		System.out.println(sb);
	}

}
