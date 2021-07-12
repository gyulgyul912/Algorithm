package com.algo.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA11856_반반 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t<=TC;t++) {
			int cnt1 = 0;
			int cnt2 = 0;
			String[] alpha = in.readLine().split("");
			String one = "";
			String two = "";
			for(int i=0;i<4;i++) {
				if(i>0 && !one.equals("") && alpha[i].equals(one)) {
					cnt1++;
				}else if(i>0 &&!two.equals("") && alpha[i].equals(two)) {
					cnt2++;
				}else if(i==0) {
					one =alpha[i];
					cnt1++;
				}else if(i>0 && two.equals("")) {
					two = alpha[i];
					cnt2++;
				}
			}
			if(cnt1==2 && cnt2==2)
				sb.append("#").append(t).append(" ").append("Yes").append("\n");
			else
				sb.append("#").append(t).append(" ").append("No").append("\n");
		}
		System.out.println(sb);
		
	}

}
