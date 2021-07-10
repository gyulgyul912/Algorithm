package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 치킨거리 {
	
	static int N,M;
	static int Min;
	static int distance;
	static int[][] Matrix;
	static int[][] select;
	public static void main(String[] args) throws IOException,NumberFormatException{
		
		// 남길 치킨집 M개 뽑아서 최소 값 비교
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());	
		Matrix = new int[N+1][N+1];
		// 집, 치킨집 저장
		// 
		LinkedList<int[]> chicken = new LinkedList<>();
		LinkedList<int[]> house = new LinkedList<>();
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=1;j<=N;j++) {
				Matrix[i][j] = Integer.parseInt(st.nextToken());				
				if(Matrix[i][j]==2) {
					int[] idx = new int[2];
					idx[0] = i;
					idx[1] = j;			
					chicken.add(idx);
				}else if(Matrix[i][j]==1) {
					int[] idx = new int[2];
					idx[0] = i;
					idx[1] = j;			
					house.add(idx);
				}			
			}
		}
		select = new int[M][2];
		// M개 만큼 치킨집의 거리 최소 구하기
		Min= Integer.MAX_VALUE;
		combination(0,0,chicken,house);
		System.out.println(Min);
		
	}
	private static void combination(int cnt, int start,LinkedList<int[]> chicken,LinkedList<int[]> house) {

		if(cnt==M){
			// 집 기준 거리 구하기
			int totald = 0;
			for(int i=0;i<house.size();i++) {
				int dis = 0, dmin = Integer.MAX_VALUE;
				for(int j=0;j<select.length;j++) {
					dis= Math.abs(house.get(i)[0]-select[j][0])+Math.abs(house.get(i)[1]-select[j][1]);
					if(dmin>dis) dmin=dis;
				}
				totald+=dmin;
			}
			if(Min>totald) Min = totald;

			return;
		}
		for(int i =start;i<chicken.size();i++) {
			select[cnt] = chicken.get(i);
			combination(cnt+1,i+1,chicken,house);
			
		}
		
	}

}
