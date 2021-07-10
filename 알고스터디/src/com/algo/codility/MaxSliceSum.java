package com.algo.codility;

public class MaxSliceSum {
	
	public static void main(String[] args) {
		
		int[] A = {3,2,-6,4,0};
		System.out.println(solution(A));
	}

	private static int solution(int[] a) {
		int answer = 0;
		int max = Integer.MIN_VALUE;
		int start = 0;
		int end = 0;
		for(int i=0;i<a.length;i++) {
			int sum = 0;
			for(int j = 0;j<=i;j++) {
				sum+=a[i];
			}
//			for(;)
		}
		return answer=max;
		
	}

}
