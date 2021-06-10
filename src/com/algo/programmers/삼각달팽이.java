package com.algo.programmers;

import java.util.Scanner;

public class 삼각달팽이 {
	
	public static void main(String[] args) {
		
		int n = 6;
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		solution(n);	
	}

	private static int[] solution(int n) {

		int[] dr = {1,0,-1};
		int[] dc = {0,1,-1};
		int[][] dalpaeng = new int[n][n];
	
		int total = (n*(n+1))/2;
		int[] answer = new int[total];
	
		int r = -1;
		int c = 0;
		int cnt = 1;
		int i = 0;
		
		while(cnt<=total) {
			r+=dr[i];
			c+=dc[i];
			if(r>=0 &&r<n && c>=0 && c<n && dalpaeng[r][c]==0) {
				dalpaeng[r][c] = cnt;
				cnt++;
			}else {
				if(i==2) {
					r++;
					c++;
					i=0;
					continue;
				}
				r-=dr[i];
				c-=dc[i];
				i = (i+1)%3;
			}
		}
		int k = 0;
		for(int[] a : dalpaeng) {
			for(int b : a) {
				if(b==0) continue;
					answer[k] = b;
					k++;
			}
		}

		return answer;
		
	}

}
