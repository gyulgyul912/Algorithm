package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class 삼대측정 {

	// K 팀원 3명의 레이팅 합
	// L 개인 레이팅 클럽 가입 조건

	public static void main(String[] args) throws IOException, NumberFormatException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] str = in.readLine().split(" ");

		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		int L = Integer.parseInt(str[2]);


		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int[] p = new int[3]; // 팀원 3명
			String[] team = in.readLine().split(" ");
			
			p[0] = Integer.parseInt(team[0]);
			p[1] = Integer.parseInt(team[1]);
			p[2] = Integer.parseInt(team[2]);
			
			if (p[0] < L || p[1] < L || p[2] < L)
				continue;
			if (p[0] + p[1] + p[2] < K)
				continue;
			
			if(cnt!=0)sb.append(" ");
			sb.append(p[0]).append(" ").append(p[1]).append(" ").append(p[2]);
				cnt++;
//			sb.append(p[0]).append(" ").append(p[1]).append(" ").append(p[2]).append(" ");
//			sb.append(p[0] + " ");
//			sb.append(p[1] + " ");
//			sb.append(p[2] + " ");
		}
		System.out.println(cnt);
		System.out.print(sb);
	}

}
