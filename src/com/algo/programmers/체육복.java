package com.algo.programmers;

import java.util.LinkedList;

public class 체육복 {

	public static void main(String[] args) {

		int[] lost = { 2, 4 };
		int[] reserve = { 2 , 4 };
		System.out.println(solution(5, lost, reserve));

	}

	public static int solution(int n, int[] lost, int[] reserve) {

		int answer = 0;

		LinkedList<Integer> list = new LinkedList<>();
		LinkedList<Integer> reserved = new LinkedList<>();
		
		// 잃어버린 사람
		for (int i = 0; i < lost.length; i++) {
			list.add(lost[i]);
		}
		for(int i=0;i<reserve.length;i++) {
			reserved.add(reserve[i]);
		}
		// 빌려주기 구현
		for (int i = 0; i < reserve.length; i++) {

			// 같은 것이 있으면
			if (list.indexOf(reserve[i]) >= 0) {
				// 똔똔
				list.remove(list.indexOf(reserve[i]));
				reserved.remove(reserved.indexOf(reserve[i]));
			}
		}
		for (int i = 0; i < reserved.size(); i++) {


				// 여벌 가지고 있는 애 앞이 잃어버린 애면
			 if (list.indexOf(reserved.get(i) - 1) >= 0) {
				list.remove(list.indexOf(reserved.get(i)- 1));
				// 뒤에가 잃어버린 애면
			} else if (list.indexOf(reserved.get(i) + 1) >= 0) {
				list.remove(list.indexOf(reserved.get(i) + 1));
			}

		}

		return answer = n - list.size();
	}
}
