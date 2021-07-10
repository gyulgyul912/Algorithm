package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 알고리즘문제 {
	
	static int N;
	static int[][] place;
	static int power = 10;
	static int sec;
	static class Info implements Comparable<Info>{

		int x;
		int y;
		int distance;
		
		public Info(int x, int y,int distance) {
			super();
			this.x = x;
			this.y = y;
			this.distance = distance;
		}

		@Override
		public int compareTo(Info o) {
			if(this.distance==o.distance) {
				if(this.x<o.x) {
					return 1;
				}else if(this.x==o.x) {
					return this.y-o.y;
				}
			}
			return 1;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		StringTokenizer st;
		int r = -1;
		int c = -1;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<N;j++) {
				place[i][j] = Integer.parseInt(st.nextToken());
				if(place[i][j]==-1) {
					r = i;
					c = j;
				}
			}
		}
		// 가장 가까운 곳에 위치한 흡수 가능 사람 찾기
		bfs(r,c);	
	}
	
	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {r,c});
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			if(place[now[0]][now[1]]<power) {
				power+=place[now[0]][now[1]];
				place[now[0]][now[1]] = 0;
				sec++;
			}
			for(int i=0;i<4;i++) {
				int nr = now[0]+dr[i];
				int nc = now[1]+dc[i];
//				if(nr>=0 && nr<)
			}
			
		}
	}
}
