package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z {
	
	static int N;
	static int R;
	static int C;
	static int cnt;
	public static void main(String[] args) throws IOException, NumberFormatException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		cnt = 0;
		int size = (int) Math.pow(2, N);
		
		recursive(size,0,0);
		
	}
	private static void recursive(int n, int x, int y) {
		int m = n/2;
		System.out.println("m : "+m+" x: "+x+" y: "+y);
		if(n==1) {
			for(int i=0;i<2;i++) {
				for(int j=0;j<2;j++) {
					if(x+i==R && y+j==C) {
						System.out.println(cnt);
						break;
					}
					cnt++;
				}
			}			
			return;
		}
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				recursive(m,x+i*m,y+j*m);
			}
		}
		
	}
}
