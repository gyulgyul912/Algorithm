package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ17298_오큰수 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Stack<Integer> stack = new Stack<>();
		stack.add(0);
		int idx = 1;
		for (int i = 1; i <= N - 1; i++) {
			while (!stack.isEmpty() && num[i] > num[stack.peek()]) {
				num[stack.pop()] = num[i];
			}
			stack.add(i);
		}
		while(!stack.isEmpty()) {
			num[stack.pop()] = -1;
		}
		for(int i=0;i<N-1;i++) {
			sb.append(num[i]).append(" ");
		}
		System.out.println(sb.toString()+"-1");
	}

}
