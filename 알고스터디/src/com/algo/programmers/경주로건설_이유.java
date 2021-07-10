package com.algo.programmers;
import java.util.Arrays;

class Solution {
    static int dx[] = { 0, 1, 0, -1 };
    static int dy[] = { 1, 0, -1, 0 };
    static int N;
    static boolean GARO = true;
    static boolean SERO = false;
    
    public int solution(int[][] board) {
        N = board.length;
		
		int money[][] = new int[N][N];
		for(int i=0;i<N;i++)
			Arrays.fill(money[i], Integer.MAX_VALUE);
		money[0][0] = 0;	
		
        dfs(0, 0, SERO, board, money);
		dfs(0, 0, GARO, board, money);
		
        return money[N-1][N-1];
    }
    
    private void dfs(int r, int c, boolean dir, int[][] board, int[][] money) {
		if(r == N-1 && c == N-1)
			return;
		
		if(board[r][c] == 1)
			return;
		
		
		for(int d=0;d<4;d++) {
			int nr = r+dx[d];
			int nc = c+dy[d];
			
			if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
				int mon = money[r][c] + 100;
				// 현재 방향이 가로
				if(dir == GARO) {
					// 가로 유지
					if(d == 0 || d == 1) {
						if(mon <= money[nr][nc]) {
							money[nr][nc] = mon;
							dfs(nr, nc, GARO, board, money);
						}
					}
					// 코너 발생
					else {
						if(mon+500 <= money[nr][nc]) {
							money[nr][nc] = mon+500;
							dfs(nr, nc, SERO, board, money);
						}
					}
				}
				// 현재 방향이 세로
				else {
					// 세로 유지
					if(d == 2 || d == 3) {
						if(mon <= money[nr][nc]) {
							money[nr][nc] = mon;
							dfs(nr, nc, SERO, board, money);
						}
					}
					// 코너 발생
					else {
						if(mon+500 <= money[nr][nc]) {
							money[nr][nc] = mon+500;
							dfs(nr, nc, GARO, board, money);
						}
					}
				}
			}
		}		
	}
}