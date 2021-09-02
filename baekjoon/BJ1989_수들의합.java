package com.algo.baekjoon;

import java.util.Scanner;

public class BJ1989_수들의합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		long sum = 1;
		long cnt = 1;
		while(sum<N) {
			sum+=(++cnt);
			
		}
		if(sum==N) {
			System.out.println(cnt);
		}else if(sum>N) {
			System.out.println(cnt-1);
		}
	}
}
