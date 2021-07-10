package com.algo.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 요세푸스문제 {
	
	public static void main(String[] args) throws IOException, NumberFormatException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			queue.offer(i+1);
		}
		
		while(!queue.isEmpty()) {
			for(int i=0;i<K;i++) {
				if(i==K-1) {
					sb.append(queue.poll());
					if(!queue.isEmpty()) {
						sb.append(", ");
					}
				}else {
					queue.add(queue.poll());
				}
			}	
		}
		
		System.out.println("<"+sb.toString()+">");
	}

}
