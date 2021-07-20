package com.algo.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA11788_Calkin_Wilftree1 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 1;t<=TC;t++) {
			String[] str = in.readLine().split("");
			int a = 1;
			int b = 1;
			for(int i=0;i<str.length;i++) {
				if(str[i].equals("L")) {
					b = a+b;
				}else {
					a = a+b;
				}
			}
			sb.append("#").append(t).append(" ").append(a).append(" ").append(b).append("\n");
		}
		System.out.println(sb.toString());
	}

}
