package com.algo.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA1984_중간평균값구하기 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(in.readLine());
		StringBuilder sb= new StringBuilder();
		StringTokenizer st;
		for(int t=1; t<=TC;t++) {
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			st = new StringTokenizer(in.readLine());
			while(st.hasMoreTokens()) {
				pq.add(Integer.parseInt(st.nextToken()));
			}
			pq.poll();
			int sum = 0;
			while(pq.size()>1) {
				sum+=pq.poll();
			}
			double answer = sum/8.0;
			sb.append("#").append(t).append(" ").append(Math.round(answer)).append("\n");
			
					
		}
		System.out.println(sb);
	}

}
