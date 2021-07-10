package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ17204_죽음의게임 {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int boseung = Integer.parseInt(st.nextToken());
		
		int[] person = new int[N];
		for(int i=0;i<N;i++) {
			person[i] = Integer.parseInt(in.readLine());
		}
		int now = person[0];
		int num = 1;
		while(num<=N) {
			if(now==boseung) {

				break;
			}
			now = person[now];
			num++;
		}
			System.out.println(num>N ? -1 : num);
		
	}
}
