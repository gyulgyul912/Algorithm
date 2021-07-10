package com.algo.programmers;

import java.util.ArrayList;
import java.util.List;

public class 두개뽑아더하기 {
	
	
	public static void main(String[] args) {
		
		
		int[] numbers= {2,1,3,4,1};
		solution(numbers);
		int[] numbers1 = {5,0,2,7};
		solution(numbers1);
	}

	private static void solution(int[] numbers) {
		
		List<Integer> list = new ArrayList<>();
		
		
		int size = numbers.length;
		int sum =0;
		for(int i=0;i<size;i++) {
			for(int j=i+1;j<size;j++) {
				sum = numbers[i]+numbers[j];
				
				if(list.indexOf(sum)<0) {
					list.add(sum);
				}
			}
		}

		list.sort(null);	// 왜 null 을 써주는지 찾기
		int[] answers = new int[list.size()];
		for(int i=0;i<list.size();i++) {
			answers[i] = list.get(i);	// 형변환 안해도 되네?

		}
	
		
	}


}
