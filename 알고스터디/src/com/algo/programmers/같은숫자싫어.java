package com.algo.programmers;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class 같은숫자싫어 {
	
	public static void main(String[] args) {
		int[] array= {1, 1, 3, 3, 0, 1, 1}; 
		int[] answer = {};
		
		// 연속된 값들을 하나로 처리
		// 하나의 값을 기준으로 다른 것이 나올 때까지 넘어가고
		// 다른 값이 나오면 그 값을 기준으로 바꿔
		// 비교하면서 넘어가는 방식
		// 몇 개의 값이 나올지 모르고 순서를 지켜야하므로 Queue 선택
		Queue<Integer> q = new LinkedList<Integer>();
		// 기준 
		int standard = array[0];
		// 처음 애는 무조건 있어야 함
		q.add(standard);
		for(int i=1;i<array.length;i++) {
			// 기준과 다른 애가 나올 때까지
			if(standard != array[i]){	
				q.add(standard = array[i]);		
			}
			
		}
		answer = new int[q.size()];
		for(int i=0;i<answer.length;i++) {
			answer[i] = q.poll();
		}

		
	}

}
