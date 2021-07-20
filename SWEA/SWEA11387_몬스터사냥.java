package com.algo.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA11387_몬스터사냥 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=TC;t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int D = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int damage = 0;
			for(int i=0;i<N;i++) {
				damage+=D*(1+i*L*0.01);
			}
			sb.append("#").append(t).append(" ").append(damage).append("\n");
		}
		System.out.println(sb.toString());
	}

}
