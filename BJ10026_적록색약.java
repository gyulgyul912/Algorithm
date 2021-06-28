package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ10026_적록색약 {
	static int N;
	static char[][] picture;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static class Area{
		int x;
		int y;
		char color;
		public Area(int x, int y, char color) {
			super();
			this.x = x;
			this.y = y;
			this.color = color;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		picture = new char[N][N];
		for(int i=0;i<N;i++) {
			String[] str = in.readLine().split("");
			for(int j=0;j<N;j++) {
				picture[i][j] = str[j].charAt(0);
			}
		}
		int normalCnt = 0;
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					searchArea(picture[i][j],i,j);
					normalCnt++;
				}				
			}
		}
		int abnormalCnt = 0;
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					searchArea2(picture[i][j],i,j);
					abnormalCnt++;
				}				
			}
		}
		System.out.println(normalCnt+" "+abnormalCnt);
	}
	private static void searchArea2(char color,int x, int y) {
		Queue<Area> q = new LinkedList<Area>();
		q.offer(new Area(x,y,color));
		while(!q.isEmpty()) {
			Area area = q.poll();			
			for(int i=0;i<4;i++) {
				int nx = area.x+dx[i];
				int ny = area.y+dy[i];
				if(nx>=0 && nx<N && ny>=0 && ny<N&& !visited[nx][ny]) {
					if((area.color=='R' || area.color=='G') && (picture[nx][ny]=='R'||picture[nx][ny]=='G')) {
						q.offer(new Area(nx,ny,color));
						visited[nx][ny] = true;
					}else if(picture[nx][ny]=='B' && picture[nx][ny]==area.color){
						q.offer(new Area(nx,ny,color));
						visited[nx][ny] = true;
					}

				}
			}
		}	
	}
	private static void searchArea(char color,int x, int y) {
		Queue<Area> q = new LinkedList<Area>();
		q.offer(new Area(x,y,color));
		while(!q.isEmpty()) {
			Area area = q.poll();			
			for(int i=0;i<4;i++) {
				int nx = area.x+dx[i];
				int ny = area.y+dy[i];
				if(nx>=0 && nx<N && ny>=0 && ny<N && picture[nx][ny]==color && !visited[nx][ny]) {
					q.offer(new Area(nx,ny,color));
					visited[nx][ny] = true;
				}
			}
		}
		
	}

}
