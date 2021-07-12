package com.algo.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SEWEA2005_파스칼의삼각형 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 1;t<=TC;t++) {
			int N = Integer.parseInt(in.readLine());
			int[][] pascal = new int[N][N];
			sb.append("#").append(t).append(" ").append("\n");
			for(int i=0;i<N;i++) {
				for(int j=0;j<=i;j++) {
					if(j-1<0 || j==i) {
						pascal[i][j] = 1;
					}else {
						pascal[i][j] = pascal[i-1][j-1]+pascal[i-1][j];
					}
					sb.append(pascal[i][j]).append(" ");
				}
				sb.append("\n");
			}	
		}
		System.out.println(sb);
	}

}
