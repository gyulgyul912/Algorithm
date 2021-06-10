package com.algo.programmers;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class 베스트앨범 {
	public static void main(String[] args) {

		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };
		solution(genres, plays);

	}

	public static int[] solution(String[] genres, int[] plays) {
		int[][] kinds = new int[100][];
		int[] answer = {};
		String[][] copy = new String[genres.length][2];
		for (int i = 0; i < genres.length; i++) {
			copy[i][0] = Integer.toString(i);
			copy[i][1] = genres[i];
		}
		Arrays.sort(copy, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				String a = o1[1];
				String b = o2[1];
				return a.compareTo(b);
			}

		});
		
		

		return answer;

	}

}
