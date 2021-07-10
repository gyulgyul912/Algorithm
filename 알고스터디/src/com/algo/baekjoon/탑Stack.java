package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑Stack {

	public static void main(String[] args)throws IOException,NumberFormatException{

		
		// 같은 방법으로 했는데 Scanner는 안되고 BufferedReader 는 됨.
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int topNum = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[][] top = new int[topNum][2];
		for (int i = 0; i < topNum; i++) {
			top[i][0] = Integer.parseInt(st.nextToken());
			top[i][1] = i+1;

		}
		Stack<int[]> stack = new Stack<>();
		stack.push(top[0]); // 첫번째꺼 저장
		int[] idx = new int[topNum];
		for (int i = 1; i < topNum; i++) {
			while (true) {
				if(stack.isEmpty()) {
					stack.push(top[i]);
					break;
				}
				else if (stack.peek()[0] < top[i][0]) { //
					stack.pop();
					if (stack.isEmpty()) { // 비어 있을 때는 0
						idx[i] = 0;
						stack.push(top[i]);
						break;
					} else if (stack.peek()[0] > top[i][0]) {
						idx[i] = stack.peek()[1];

						stack.push(top[i]);
						break;
					} else if (stack.peek()[0] < top[i][0]) {
						stack.pop();
						continue;
					}
				} else if (stack.peek()[0] > top[i][0]) {
					idx[i] = stack.peek()[1]; // 스택의 젤 위에 있는것의 인덱스

					stack.push(top[i]);
					break;
				}
			}
		}
		for(int x : idx) {
			System.out.print(x+" ");
		}
		
	}

}
