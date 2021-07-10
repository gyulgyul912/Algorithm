package com.algo.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 블록이동하기 {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int minSec = Integer.MAX_VALUE;
	public static class Location{
		int[] one;
		int[] two;
		int dir;
		int sec;
		public Location(int[] one, int[] two, int dir,int sec) {
			super();
			this.one = one;
			this.two = two;
			this.dir = dir;
			this.sec = sec;
		}
	}
	public static void main(String[] args) {
		int[][] board = {{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}};
		
		System.out.println(solution(board));
	}

	private static int solution(int[][] board) {
		int answer = 0;
		int N = board.length;
		int[][] sec = new int[N][N];
		for(int i=0;i<N;i++) {
			Arrays.fill(sec[i], Integer.MAX_VALUE);
		}
		Queue<Location> q = new LinkedList<Location>();
		q.offer(new Location(new int[] {0,0},new int[] {0,1},0,0));
		sec[0][0] = 0;
		sec[0][1] = 0;
		while(!q.isEmpty()) {
			Location loc = q.poll();
			if((loc.one[0]==N-1 && loc.one[1]==N-1)||(loc.two[0]==N-1 && loc.two[1]==N-1)) {
				if(minSec>loc.sec)minSec = loc.sec;
			}
			// 가로
			if(loc.dir==0) {
				for(int k=2;k<4;k++) {
					if(k==2) {// 왼쪽으로 이동
						int nx = loc.one[0]+dx[k];
						int ny = loc.one[1]+dy[k];
						if(nx>=0 && nx<N && ny>=0 && ny<N && board[nx][ny]!=1&& sec[nx][ny]>loc.sec) {
							q.offer(new Location(new int[] {nx,ny},new int[] {loc.one[0],loc.one[1]},loc.dir,loc.sec+1));
						}
					}else {
						int nx = loc.two[0]+dx[k];
						int ny = loc.two[1]+dy[k];
						if(nx>=0 && nx<N && ny>=0 && ny<N && board[nx][ny]!=1&& sec[nx][ny]>loc.sec) {
							q.offer(new Location(new int[] {loc.two[0],loc.two[1]},new int[] {nx,ny},loc.dir,loc.sec+1));
						}
					}				
				}
				// 회전이동 가능?
				int nx = loc.one[0]+1;
				if(nx>=0 && nx<N && board[nx][loc.one[1]]!=1 && board[nx][loc.two[1]]!=1) {
					if(sec[nx][loc.one[1]]>loc.sec) {
						q.offer(new Location(new int[] {loc.one[0],loc.one[1]},new int[] {nx,loc.one[1]},loc.dir+1,loc.sec+1));
					}
					if(sec[nx][loc.two[1]]>loc.sec) {
						q.offer(new Location(new int[] {loc.two[0],loc.two[1]},new int[] {nx,loc.two[1]},loc.dir+1,loc.sec+1));
					}
				}
				nx = loc.one[0]-1;
				if(nx>=0 && nx<N && board[nx][loc.one[1]]!=1 && board[nx][loc.two[1]]!=1) {
					if(sec[nx][loc.one[1]]>loc.sec) {
						q.offer(new Location(new int[] {nx,loc.one[1]},new int[] {loc.one[0],loc.one[1]},loc.dir+1,loc.sec+1));
					}
					if(sec[nx][loc.two[1]]>loc.sec) {
						q.offer(new Location(new int[] {nx,loc.two[1]},new int[] {loc.two[0],loc.two[1]},loc.dir+1,loc.sec+1));
					}
				}
			}			
			// 세로
			else {
				for(int k=0;k<2;k++) {
					if(k==0) {// 위로 이동
						int nx = loc.one[0]+dx[k];
						int ny = loc.one[1]+dy[k];
						if(nx>=0 && nx<N && ny>=0 && ny<N && board[nx][ny]!=1&& sec[nx][ny]>loc.sec) {
							q.offer(new Location(new int[] {nx,ny},new int[] {loc.one[0],loc.one[1]},loc.dir,loc.sec+1));
						}
					}else {
						int nx = loc.two[0]+dx[k];
						int ny = loc.two[1]+dy[k];
						if(nx>=0 && nx<N && ny>=0 && ny<N && board[nx][ny]!=1&& sec[nx][ny]>loc.sec) {
							q.offer(new Location(new int[] {loc.two[0],loc.two[1]},new int[] {nx,ny},loc.dir,loc.sec+1));
						}
					}				
				}
				// 회전이동 가능?
				int ny = loc.one[1]+1;
				if(ny>=0 && ny<N && board[loc.one[0]][ny]!=1 && board[loc.two[0]][ny]!=1) {
					if(sec[loc.one[0]][ny]>loc.sec) {
						q.offer(new Location(new int[] {loc.one[0],loc.one[1]},new int[] {loc.one[0],ny},loc.dir-1,loc.sec+1));
					}
					if(sec[loc.two[0]][ny]>loc.sec) {
						q.offer(new Location(new int[] {loc.two[0],loc.two[1]},new int[] {loc.two[0],ny},loc.dir-1,loc.sec+1));
					}
				}
				ny = loc.one[0]-1;
				if(ny>=0 && ny<N && board[loc.one[0]][ny]!=1 && board[loc.two[0]][ny]!=1) {
					if(sec[loc.one[0]][ny]>loc.sec) {
						q.offer(new Location(new int[] {loc.one[0],ny},new int[] {loc.one[0],loc.one[1]},loc.dir+1,loc.sec+1));
					}
					if(sec[ny][loc.two[1]]>loc.sec) {
						q.offer(new Location(new int[] {loc.two[0],ny},new int[] {loc.two[0],loc.two[1]},loc.dir+1,loc.sec+1));
					}
				}
			}			
		}
		
		
		return answer = minSec;
	}

}
