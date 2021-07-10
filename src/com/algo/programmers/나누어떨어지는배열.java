package com.algo.programmers;

import java.util.Arrays;

public class 나누어떨어지는배열 {

	public static void main(String[] args) {

		solution(new int[4], 5);

	}

	static public int[] solution(int[] arr, int divisor) {

		int size = arr.length;

		int cnt = 0;
		for (int i = 0; i < size; i++) {
			if (arr[i] % divisor == 0) {
				cnt++;
			}
		}
		if (cnt == 0) {
			int[] answer = { -1 };
			return answer;
		} else {
			int[] answer = new int[cnt];
			int idx = 0;
			for (int i = 0; i < size; i++) {
				if (arr[i] % divisor == 0) {
					answer[idx++] = arr[i];
				}
			}
			Arrays.sort(answer);
			return answer;
		}
	}

}
