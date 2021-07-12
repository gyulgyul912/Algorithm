package com.algo.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA2007_패턴마디의길이 {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 1;t<=TC;t++) {
			int cnt = 0;
			String str = in.readLine();
			int i=0;
			int j=1;
			for(;j<30;j++) {
				if(str.charAt(i)==str.charAt(j)) {
					i++;
				}else {
					i=0;
				}
			}
			
			sb.append("#").append(t).append(" ").append(j-i).append("\n");
		}
		System.out.println(sb);
	}
}
