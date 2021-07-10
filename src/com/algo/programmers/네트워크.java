package com.algo.programmers;

public class 네트워크 {
	
	public static void main(String[] args) {
		
		int n = 3;
		int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
		
		System.out.println(solution(n,computers));
	}
	static boolean[] visited;
	public static int solution(int n, int[][] computers) {
		int answer = 0;
		visited = new boolean[n];
		for(int i=0;i<n;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			answer++;
			dfs(i,computers,n);
		}
		return answer;
		
	}
	private static void dfs(int idx, int[][] computers,int n) {
		for(int i=0;i<n;i++) {
			System.out.println("idx : "+idx+ " i : "+i);
			if(i==idx) continue;
			if(!visited[i] && computers[idx][i]==1) {
				visited[i] = true;
				dfs(i,computers,n);
			}	
		}

		
	}

}
