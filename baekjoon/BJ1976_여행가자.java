	package com.algo.baekjoon;
	
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.StringTokenizer;
	
	public class BJ1976_여행가자 {
		
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(in.readLine());
			int M = Integer.parseInt(in.readLine());
			
			int[][] connect = new int[N][N];
			StringTokenizer st;
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(in.readLine());
				for(int j=0;j<N;j++) {
					connect[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int k=0;k<N;k++) {
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(i==j) {
							connect[i][j]=1;
							continue;
						}
						if(k==i|| k==j)continue;
						if(connect[i][k]==1 && connect[k][j]==1) {
							connect[i][j]=1;
							connect[j][i]=1;
						}
					}
				}
			}
			int[] tour = new int[M];
			st = new StringTokenizer(in.readLine());
			for(int i=0;i<M;i++) {
				tour[i] = Integer.parseInt(st.nextToken())-1;
			}
			boolean can = true;
			for(int i=1;i<M;i++) {
				if(connect[tour[0]][tour[i]]!=1) {			
					sb.append("NO");
					can = false;
					break;
				}
			}
			if(can)
				sb.append("YES");
			System.out.println(sb.toString());
		}	
	}
