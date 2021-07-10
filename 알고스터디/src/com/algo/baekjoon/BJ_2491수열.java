package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_2491수열 {

	public static void main(String[] args) throws IOException, NumberFormatException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// 수열의 길이
		int N = Integer.parseInt(in.readLine());
		// 수열 담을 공간
		int[] num = new int[N];
		String[] str = in.readLine().split(" ");
		// 수열 저장
		for(int i=0;i<N;i++) {
			num[i]= Integer.parseInt(str[i]);
		}
		int maxA = 1;	// 구간 길이 중 최댓값 Integer.Min_value 로 하니까 안됨
		int maxD = 1;	// 구간 길이 중 최댓값
		int asc= 1;	// 커지는 구간의 길이 측정
		int des = 1; // 작아지는 구간 길이 측정
		
		// if else 에서 peek 둘 중 하나만 동작할 까?
		// 등호 한번 해보기 둘 다 넣어보기 하나만넣어보기		
		for(int i=1;i<N;i++) {
			if(num[i-1]<=num[i]) asc++;
			else asc = 1;
			maxA = maxA> asc ? maxA : asc;			
		}		
		for(int i=1;i<N;i++) {
			if(num[i-1]>=num[i]) des++;
			else des=1;
			maxD = maxD > des ? maxD : des;

		}
		System.out.println(Math.max(maxA, maxD));
		
	}

}

//import java.util.Scanner;
//public class BJ_2491수열{
//	static int N;
//	static int[] arr;
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		N = sc.nextInt();
//		arr = new int[N];
//		for(int i=0;i<N;i++) {
//			arr[i] = sc.nextInt();
//		}
//		
//		int cnt = 1;
//		int ans = 1;
//		
//		for(int i=1;i<N;i++) {
//			if(arr[i-1]>=arr[i]) cnt++;
//			else cnt = 1;
//			if(ans < cnt) ans = cnt;
//		}
//		cnt = 1;
//		for(int i=1;i<N;i++) {
//			if(arr[i-1]<=arr[i])cnt++;
//			else cnt=1;
//			if(ans<cnt) ans = cnt;
//		}
//		System.out.println(ans);
//			
//	}
//}
