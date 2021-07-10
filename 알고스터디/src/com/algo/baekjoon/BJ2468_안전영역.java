package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2468_안전영역 {
	static int N;
	static int rainMax = Integer.MIN_VALUE;
	static int safetyZone;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(rainMax<map[i][j]) rainMax = map[i][j];
			}
		}
		safetyZone = Integer.MIN_VALUE;
		for(int m=0;m<=rainMax;m++) {
			// 비의 양에 따라 안전영역 구하기
			int zone = 0;
			visited = new boolean[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]>m && !visited[i][j]) {
						bfs(i,j,m,visited);
						zone++;
					}
				}
			}
			if(safetyZone<zone)safetyZone = zone;
		}
		System.out.println(safetyZone);
	}
	private static void bfs(int i, int j,int m,boolean[][] visited) {	
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {i,j});
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.poll()[1];
			for(int k=0;k<4;k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				if(nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny]>m && !visited[nx][ny]) {
					q.offer(new int[] {nx,ny});
					visited[nx][ny] = true;
				}
			}	
		}	
	}
}
