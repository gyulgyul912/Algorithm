package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ5014_스타트링크 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {S,0});
		boolean[] visited = new boolean[F+1];
		boolean can = false;
		while(!q.isEmpty()) {
			int nowFloor = q.peek()[0];
			int buttonCnt = q.poll()[1];
//			System.out.println(nowFloor);
			if(nowFloor==G) {
				System.out.println(buttonCnt);
				can = true;
				break;
			}		
			if(nowFloor+U<=F && !visited[nowFloor+U]) {
				q.add(new int[] {nowFloor+U,buttonCnt+1});
				visited[nowFloor+U] = true;
			}
			if(nowFloor-D>=1 && !visited[nowFloor-D]) {
				q.add(new int[] {nowFloor-D,buttonCnt+1});
				visited[nowFloor-D] = true;
			}
		}
		if(!can) {
			System.out.println("use the stairs");
		}
		
	}

}
