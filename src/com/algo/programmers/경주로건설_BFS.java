package com.algo.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 경주로건설_BFS {

	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0, 1 }, { 0, 0, 1, 0, 0, 0, 1, 0 },
				{ 0, 1, 0, 0, 0, 1, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0 } };
//		int[][] board = {{0,0,0},{0,0,0},{0,0,0}};
//		int[][] board = {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
		
		System.out.println(solution(board));

	}

	static public int solution(int[][] board) {
		int answer = 0;
		int N = board.length;
		int[][] buildMoney = new int[N][N];
		for(int i=0;i<N;i++)
		Arrays.fill(buildMoney[i], Integer.MAX_VALUE);
		buildMoney[0][0] = 0;
		int minTotalDon = Integer.MAX_VALUE;
		int[][] donMap = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { 0, 0, 0, -1 });
		visited[0][0] = true;
		while (!q.isEmpty()) {
			int r = q.peek()[0];
			int c = q.peek()[1];
			int nowDon = q.peek()[2];
			int dir = q.poll()[3];			
			if (r == N - 1 && c == N - 1) {
				if (minTotalDon > nowDon) {
					minTotalDon = nowDon;
				}
			}
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && board[nr][nc] == 0) {
					if (dir == i) {		
						if(buildMoney[nr][nc]>=nowDon+100) {
							q.offer(new int[] { nr, nc, nowDon + 100, i });
							buildMoney[nr][nc] = nowDon+100;
						}
						
					} else {
						if(dir==-1) {
							q.offer(new int[] { nr, nc, nowDon + 100, i });
							buildMoney[nr][nc] = nowDon+100;
							continue;
						}			
						if(buildMoney[nr][nc]>=nowDon+600) {
							q.offer(new int[] { nr, nc, nowDon + 600, i });
							buildMoney[nr][nc] = nowDon+600;
						}	
					}
				}
			}
		}
		
		return answer = minTotalDon;
	}

}
