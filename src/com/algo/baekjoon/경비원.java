package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경비원 {
	
	public static void main(String[] args) throws IOException, NumberFormatException{
		
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m =Integer.parseInt(st.nextToken());
		
		int total = 2*n+2*m;
		
		int num = Integer.parseInt(in.readLine());
		int[][] loc = new int[num+1][2];
		int[] aa = new int[num+1];
		for(int i=0;i<=num;i++) {
			st = new StringTokenizer(in.readLine());
			int r=Integer.parseInt(st.nextToken());
			int c= Integer.parseInt(st.nextToken());		
			if(r==1) {
				loc[i][0] = 0;
				loc[i][1] = c;
			}else if(r==2) {
				loc[i][0] = -m;
				loc[i][1] = -c;
			}else if(r==3) {
				loc[i][0] = -c;
				loc[i][1] = 0;
			}else if(r==4) {
				loc[i][0] = c;
				loc[i][1] = n;
			}
			aa[i] = loc[i][0]+loc[i][1];
		}
		for(int i=0;i<=num;i++) {
			for(int j=0;j<2;j++) {
				System.out.println(loc[i][j]+" "+aa[i]);
			}
		}
		
		int cnt = 0;
		for(int i=0;i<num;i++) {
			if(Math.abs(aa[num]-aa[i])<=(total/2)) {
				cnt+=Math.abs(aa[num]-aa[i]);
			}else {
				cnt+=total-Math.abs(aa[num]-aa[i]);
			}
		}
		System.out.println(cnt);
	
	}

}
