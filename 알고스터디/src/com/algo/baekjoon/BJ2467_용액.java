package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ2467_용액 {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] dragonWater = new int[N][2];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for(int i=0;i<N;i++) {
			int now = Integer.parseInt(st.nextToken());
			if(now>0) {
				dragonWater[i][0] = now;
				dragonWater[i][1] = 1;
			}else {
				dragonWater[i][0] = -now;
				dragonWater[i][1] = -1;
			}
		
		}
		Arrays.sort(dragonWater,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return o1[0]-o2[0];
			}
		});
		int min = Integer.MAX_VALUE;
		int idx = -1;
		for(int i=0;i<N-1;i++){
			if(min>Math.abs(dragonWater[i][0]*dragonWater[i][1]+dragonWater[i+1][0]*dragonWater[i+1][1])) {
				min = Math.abs(dragonWater[i][0]*dragonWater[i][1]+dragonWater[i+1][0]*dragonWater[i+1][1]);
				idx = i;
			}
		}
		System.out.println(Math.min(dragonWater[idx][0]*dragonWater[idx][1], dragonWater[idx+1][0]*dragonWater[idx+1][1])+" "+ Math.max(dragonWater[idx][0]*dragonWater[idx][1], dragonWater[idx+1][0]*dragonWater[idx+1][1]));
	}
}
