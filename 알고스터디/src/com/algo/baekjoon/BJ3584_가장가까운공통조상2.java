package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ3584_가장가까운공통조상2 {

	static int[] parents;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(in.readLine());
		StringTokenizer st;
		for (int t = 1; t <= TC; t++) {
			int numOfNodes = Integer.parseInt(in.readLine());
			parents = new int[numOfNodes + 1];
			for (int i = 1; i <= numOfNodes; i++) {
				parents[i] = i;
			}
			for (int i = 0; i < numOfNodes - 1; i++) {
				st = new StringTokenizer(in.readLine());
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				parents[child] = parent;
			}
			st = new StringTokenizer(in.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			int depth1 = dfs(node1);
			int depth2 = dfs(node2);

			// 공통 조상 찾기
			int ancestor = searchAncestor(depth1,node1,depth2,node2);
			System.out.println(ancestor);
		}
	}
	private static int searchAncestor(int depth1, int node1, int depth2, int node2) {
		if(depth1<depth2) {
			while(depth1!=depth2) {
				depth2--;
				node2 = parents[node2];
			}
		}else if(depth1>depth2) {
			while(depth1!=depth2) {
				depth1--;
				node1 = parents[node1];
			}
		}
		while(node1!=node2) {
			node1 = parents[node1];
			node2 = parents[node2];
		}
		
		return node1;
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
