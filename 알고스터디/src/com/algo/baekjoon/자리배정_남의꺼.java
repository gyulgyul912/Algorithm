package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 자리배정_남의꺼 {

	static int r,c;
	static int[][] deltas= {{1,0},{0,1},{-1,0},{0,-1}};	// 델타를 이렇게 써줬네
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		c=Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());
		
		int[][] map=new int[r+1][c+1];
		int K=Integer.parseInt(br.readLine());
		
		int cnt=1;
		int dx=1;
		int dy=1;
		map[dx][dy]=1;
		int k=0;
		if(K<=r*c) {
			while(cnt!=K) {
				dx+=deltas[k][0];
				dy+=deltas[k][1];
				if(isIn(dx,dy)&&map[dx][dy]==0) {
					cnt++;
					map[dx][dy]=1;
				}
				else {
					dx-=deltas[k][0];
					dy-=deltas[k][1];
					k++;
					if(k>3)
						k=0;
				}
			}
			System.out.println(dy+" "+dx);
		}
		else {
			System.out.println(0);
		}
	}
	
	static boolean isIn(int row,int col) {
		return 1<=row&&row<=r&&1<=col&&col<=c;
	}

}
