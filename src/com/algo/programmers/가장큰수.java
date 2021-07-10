package com.algo.programmers;

import java.util.LinkedList;

public class 가장큰수 {

	static boolean isSelected[];
	static int N;
	static int[] newNum;
	static LinkedList<Integer> list = new LinkedList<>();

	public static void main(String[] args) {

		// numbers 개수만큼 순열로 뽑아서
		// String으로 합친다음
		// 다시 int형으로 만들어서 배열에 저장
		// 그리고 정렬해서 마지막꺼를 답으로 적자.
		int[] numbers = { 1,2,22,3,4,5,6,7,8};
//		int[] numbers= {0,0,0,0};
		
		N = numbers.length;
		isSelected = new boolean[N];
		newNum = new int[N];
		permutation(0, numbers);
		int max = 0;
		for (int i = 0; i < list.size(); i++)
			max = max > list.get(i) ? max : list.get(i);
		System.out.println(max);

	}

	private static void permutation(int cnt, int[] numbers) {

		if (cnt == N) {
			searchMax(newNum);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (isSelected[i])
				continue;
			isSelected[i] = true;
			newNum[cnt] = numbers[i];
			permutation(cnt + 1, numbers);
			isSelected[i] = false;
		}

	}
	private static void searchMax(int[] newNum) {
		String fnts = "";
		for (int i = 0; i < newNum.length; i++) {
			fnts += Integer.toString(newNum[i]);
		}
		if ((fnts.length() > 1 && fnts.charAt(0) != '0') || (fnts.length() == 1 && fnts.charAt(0) == '0'))
			list.add(Integer.parseInt(fnts));

	}

}
