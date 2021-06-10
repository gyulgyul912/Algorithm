package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ10615_숫자카드 {
	static int[] cards;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		cards = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cards);
		int M = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<M;i++) {
			int num = Integer.parseInt(st.nextToken());
			if(binaraySearch(num,N))sb.append("1");
			else sb.append("0");
			if(i!=M-1)sb.append(" ");	
		}
		System.out.println(sb);
	}
	private static boolean binaraySearch(int num,int n) {
		int start = 0;
		int end = n-1;		
		while(start<=end) {
			int mid = (start+end)/2;
			int now = cards[mid];
			if(num<now) end = mid-1;
			else if(num>now) start = mid+1;
			else if(num==now) return true;
		}
		
		return false;
	}

}
