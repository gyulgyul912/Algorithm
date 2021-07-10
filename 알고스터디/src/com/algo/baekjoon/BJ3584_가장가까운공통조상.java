package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ3584_가장가까운공통조상 {
	static int[] parents;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(in.readLine());
		StringTokenizer st;
		for (int t = 1; t <= TC; t++) {
			int numOfNodes = Integer.parseInt(in.readLine());
			parents = new int[numOfNodes + 1];
			for(int i=0;i<=numOfNodes;i++) {
				parents[i] = i;
			}
			for (int i = 1; i <= numOfNodes - 1; i++) {
//				parents[i] = i;
				st = new StringTokenizer(in.readLine());
				int parent = Integer.parseInt(st.nextToken());
				int baby = Integer.parseInt(st.nextToken());
				parents[baby] = parent;
			}
			st = new StringTokenizer(in.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			int depth1 = dfs(num1);
			int depth2 = dfs(num2);
			if(depth1<depth2) {
				int temp = num1;
				num1 = num2;
				num2 = temp;
			}
			// 조상 찾기
			boolean[] visitedNum1 = new boolean[numOfNodes + 1];
			boolean[] visitedNum2 = new boolean[numOfNodes + 1];
			while (true) {

				if(parents[num1]==num1 &&parents[num2]==num2) {
					System.out.println(num1);
					break;
				}
				int parent1 = parents[num1];
				int parent2 = parents[num2];
				visitedNum1[parent1] = true;
				visitedNum2[parent2] = true;
				if (visitedNum1[parent1] && visitedNum2[parent1]) {
					System.out.println(parent1);
					break;
				}
				if (visitedNum2[parent2] && visitedNum1[parent2]) {
					System.out.println(parent2);
					break;
				}
				num1 = parent1;
				num2 = parent2;
			}
		}
	}
	private static int dfs(int node) {
		int depth = 0;
		while(parents[node]!=node) {
			depth++;
			node = parents[node];
		}
		return depth;
	}

}
