package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2527직사각형 {

	public static void main(String[] args) throws IOException, NumberFormatException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < 4; t++) {
			String[] str = in.readLine().split(" ");
			// 좌표 저장
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			int p = Integer.parseInt(str[2]);
			int q = Integer.parseInt(str[3]);

			int x1 = Integer.parseInt(str[4]);
			int y1 = Integer.parseInt(str[5]);
			int p1 = Integer.parseInt(str[6]);
			int q1 = Integer.parseInt(str[7]);
			
			if(x1>p || p1<x || q1<y || q<y1) {
				sb.append("d").append("\n");

			}else if((x==p1 && y==q1) || (p==x1 && y==q1) ||(p==x1 && q==y1) || (x==p1 && q==y1)){
				sb.append("c").append("\n");
			}else if((x==p1 && y!=q1) || (p==x1 && y!=q1) || (p!=x1 && q==y1) || (x!=p1 && q1==y)) {
				sb.append("b").append("\n");
			}
			else sb.append("a").append("\n");

		}
		System.out.print(sb);
	}

}
