package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ1759_암호만들기 {
	static int L;
	static int C;
	static String[] alphabet;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alphabet = in.readLine().split(" ");
		Arrays.sort(alphabet);

		// 순열
		boolean[] visited = new boolean[alphabet.length];
		String ans = "";
		permutation(0, 0, ans, visited);

	}

	private static void permutation(int idx, int cnt, String ans, boolean[] visited) {
		if (cnt == L) {
			int jaum = 0;
			int moum = 0;
			for (int i = 0; i < L; i++) {
				if (ans.charAt(i)=='a' ||ans.charAt(i)=='e'||ans.charAt(i)=='i'||ans.charAt(i)=='o'||ans.charAt(i)=='u') {
					moum++;
				} else {
					jaum++;
				}
				if (moum >= 1 && jaum >= 2) {
					System.out.println(ans);
					break;
				}
			}
			return;
		}
		for (int i = idx; i < C; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			permutation(i + 1, cnt + 1, ans + alphabet[i], visited);
			visited[i] = false;
		}
	}

}
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.LinkedList;
//import java.util.StringTokenizer;
//
//
//public class BJ1759_암호만들기 {
//	static int L;
//	static int C;
//	static char[] alpabet;
//	static boolean[] isSelected;
//	static LinkedList<String> list = new LinkedList<>();
//
//	public static void main(String[] args) throws IOException, NumberFormatException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(in.readLine());
//		L = Integer.parseInt(st.nextToken());
//		C = Integer.parseInt(st.nextToken());
//		alpabet = new char[C];
//		isSelected = new boolean[C];
//		st = new StringTokenizer(in.readLine());
//		int i = 0;
//		while (st.hasMoreElements()) {
//			alpabet[i++] = st.nextToken().charAt(0);
//		}
//		char[] alpaSelected = new char[L];
//		Arrays.sort(alpabet);
//		combination(0, 0, alpaSelected);
//		Collections.sort(list);
//		while (!list.isEmpty()) {
//			System.out.println(list.poll());
//		}
//	}
//
//	private static void combination(int cnt, int start, char[] alpaSelected) {
//
//		if (cnt == L) {
//			int moeum = 0;
//			int jaeum = 0;
//			for (int i = 0; i < L; i++) {
//				if (alpaSelected[i] == 'a' || alpaSelected[i] == 'e' || alpaSelected[i] == 'u' || alpaSelected[i] == 'i'
//						|| alpaSelected[i] == 'o')
//					moeum++;
//				else
//					jaeum++;
//			}
//			if (moeum >= 1 && jaeum >= 2) {
//				list.add(new String(alpaSelected));
//			}
//			return;
//		}
//
//		for (int i = start; i < C; i++) {
//			alpaSelected[cnt] = alpabet[i];
//			combination(cnt + 1, i + 1, alpaSelected);
//
//		}
//
//	}
//
//}
