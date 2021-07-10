package com.algo.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 경주로건설_DFS {
	static int N;
	static int[][] buildMoney;
	static int minTotalDon = Integer.MAX_VALUE;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
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
		N = board.length;
		buildMoney = new int[N][N];
		for(int i=0;i<N;i++)
		Arrays.fill(buildMoney[i], Integer.MAX_VALUE);
		buildMoney[0][0] = 0;
		int r = 0;
		int c = 0;
		int money = 0;
		int dir = -1;
		dfs(r,c,money,dir,board);
		return answer = buildMoney[N-1][N-1];
		
	}

	private static void dfs(int r, int c, int money, int dir,int[][] board) {
		if(r==N-1 && c==N-1) {
			if(minTotalDon>money) {
				minTotalDon = money;
				return;
			}
			return;
		}		
		for(int i=0;i<4;i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr >= 0 && nr < N && nc >= 0 && nc < N && board[nr][nc] == 0) {
				if (dir == i) {		
					if(buildMoney[nr][nc]>=money+100) {
						buildMoney[nr][nc] = money+100;
						dfs(nr,nc,money+100,i,board);
					}				
				} else {
					if(dir==-1) {
						buildMoney[nr][nc] = money+100;
						dfs(nr,nc,money+100,i,board);
						continue;
					}			
					if(buildMoney[nr][nc]>=money+600) {
						buildMoney[nr][nc] = money+600;
						dfs(nr,nc,money+600,i,board);
					}	
				}
			}
		}
		
		
	}

}
