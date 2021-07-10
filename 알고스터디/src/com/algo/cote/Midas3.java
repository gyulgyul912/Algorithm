package com.algo.cote;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Midas3 {

	public static void main(String[] args) {
		int N = 4;
		int K = 4;
		int[][] T = { { 1, 3 }, { 1, 1 }, { 2, 3 }, { 3, 4 } };
//		int N = 4;
//		int K = 4;
//		int[][] T = { { 1,1 }, {1,1 }, {1,1 },{1,1 },{1,1 } };
		System.out.println(Solution(N, K, T));
	}


	private static int Solution(int N, int K, int[][] T) {
		int answer = 0;
		// 끝 날짜 빠른순 -> 
		Arrays.sort(T, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		// 상담일 별 가능한 학생 찾기
//		int studentIdx = 0;
		int stuIdx = 0;
		boolean[] visited = new boolean[K + 1];
		int day = 1;
		for(int i=0;i<N;i++) {
			day = T[i][0];
//			System.out.println("날짜 " +day+" "+T[i][0]+" "+T[i][1]);
			while(T[i][0]<=day && T[i][1]>=day) {
//				System.out.println("들어와서 " +T[i][0]+" "+T[i][1]);
				if(!visited[day]) {
					answer++;
					visited[day] = true;
					break;
				}
				day++;
			}
		}	
		
		return answer;
	}

}
