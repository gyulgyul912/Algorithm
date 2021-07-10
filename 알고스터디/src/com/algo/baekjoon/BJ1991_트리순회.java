package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ1991_트리순회 {
	static public class Node {
		char mid;
		char left;
		char right;

		public Node(char mid, char left, char right) {
			super();
			this.mid = mid;
			this.left = left;
			this.right = right;
		}
	}

	static int N;
	static String ans = "";
	static HashMap<Character, Node> map = new HashMap<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		for (int i = 0; i < N; i++) {
			String[] str = in.readLine().split(" ");
			map.put(str[0].charAt(0), new Node(str[0].charAt(0), str[1].charAt(0), str[2].charAt(0)));
		}
		// 전위 순회
		preCircuit(map.get('A'));
		System.out.println(ans);
		// 중위 순회
		ans = "";
		middleCircuit(map.get('A'));
		System.out.println(ans);
		// 후위 순회
		ans = "";
		postCircuit(map.get('A'));
		System.out.println(ans);
	}

	private static void postCircuit(Node node) {
		if (map.containsKey(node.left)) {
			postCircuit(map.get(node.left));
			if (map.containsKey(node.right))
				postCircuit(map.get(node.right));
				ans += node.mid;
		}else {
			if (map.containsKey(node.right)) {
				postCircuit(map.get(node.right));
				ans+=node.mid;
			}
			else
			ans+=node.mid;
		}
	}

	private static void middleCircuit(Node node) {
		if (map.containsKey(node.left)) {
			middleCircuit(map.get(node.left));
			ans += node.mid;

		} else {
			ans += node.mid;

		}
		if (map.containsKey(node.right))
			middleCircuit(map.get(node.right));
	}

	private static void preCircuit(Node node) {
		ans += String.valueOf(node.mid);
		if (map.containsKey(node.left))
			preCircuit(map.get(node.left));
		if (map.containsKey(node.right))
			preCircuit(map.get(node.right));
	}
}
