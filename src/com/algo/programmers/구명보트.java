package com.algo.programmers;

import java.util.Arrays;
import java.util.LinkedList;

public class 구명보트 {
	
	public static void main(String[] args) {
		
		
		int[] p = {70, 50, 80, 50};
		int limit = 100;
		
		solution(p,limit);
	}
	/*
	 * 최대 2명 탈 수 있음
	 * 
	 * 
	 */

	private static void solution(int[] people, int limit) {
		
		LinkedList<Integer> list = new LinkedList<>(); // getFirst() getLast() 있어서 사용
		
		Arrays.sort(people);
		
		for(int i=0;i<people.length;i++) {
			list.add(people[i]);
		}
		int boat_cnt = 0;
		while(!list.isEmpty()) {
			// 두 명 다 탈 수 있으면
			if(list.getFirst()+list.getLast()<=limit) {
				boat_cnt++;
				list.pollFirst();
				list.pollLast();
			}else {	// 두 명 못 탈 경우 뚱떙이 먼저 탈출
				boat_cnt++;
				list.pollLast();
			}
		}
		System.out.println(boat_cnt);
	
		
	}

}
