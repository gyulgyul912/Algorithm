package com.algo.cote;

public class Midas1 {
	
	static int[] dx = {-1,1,0,0,-1,-1,1,1};
	static int[] dy = {0,0,-1,1,-1,1,-1,1};
	
	public static void main(String[] args) {
		int[][] mine= {{1,1},{1,7},{2,7},{3,6},{4,1},{4,4},{4,8},{8,4},{8,5},{9,6}};
		solution(9,mine);
	}

	private static int[][] solution(int N, int[][] mine) {
        int[][] answer = new int[N+1][N+1];
        // 지뢰 설정
        for(int i=0;i<N;i++) {
        	answer[mine[i][0]][mine[i][1]] = -1;
        }
        // 상하좌우 대각선 4곳 중 지뢰 있으면 갯수 추가
        for(int i=1;i<=N;i++) {
        	for(int j=1;j<=N;j++) {
        		int cnt = 0;
        		for(int k=0;k<8;k++) {
        			int nx = i+dx[k];
        			int ny = j+dy[k];
        			if(nx>=1 && nx<=N && ny>=1 && ny<=N && answer[i][j]!=-1) {
        				if(answer[nx][ny]==-1)
        					cnt++;
        			}
        		}
        		answer[i][j]+=cnt;
        	}

        }
        for(int i=0;i<=N;i++) {
        	for(int j=0;j<=N;j++) {
        		System.out.print(answer[i][j]+" ");
        	}
        	System.out.println();
        }
        System.out.println();
        int[][] newAns = new int[N][N];
        for(int i=1;i<=N;i++) {
        	for(int j=1;j<=N;j++) {
        		newAns[i-1][j-1] = answer[i][j];
        	}
        }
        for(int i=0;i<N;i++) {
        	for(int j=0;j<N;j++) {
        		System.out.print(newAns[i][j]+" ");
        	}
        	System.out.println();
        }
        return newAns;
	}

}
