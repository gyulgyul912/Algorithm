package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 배열돌리기3 {



	public static void main(String[] args) throws IOException, NumberFormatException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] str = in.readLine().split(" ");
		int N;
		int M;
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		int R = Integer.parseInt(str[2]);

		int[][] map = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			String[] ss = in.readLine().split(" ");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(ss[j - 1]);

			}

		}

		String[] cs = in.readLine().split(" ");
		int[][] newmap = map;
		for (int t = 0; t < cs.length; t++) {
			int[][] nmap = newmap;
			N = newmap.length-1;
			M = newmap[0].length-1;
			switch (Integer.parseInt(cs[t])) {
			case 1:
				newmap = UpDown(nmap,N,M);	
				break;
			case 2:
				newmap = LeftRight(nmap,N,M);
				break;
			case 3:
				newmap = RightRotation(nmap,N,M);
				break;
			case 4:
				newmap = LeftRotation(nmap,N,M);
				break;
			case 5:
				newmap = PartClockWRotation(nmap,N,M);
				break;
			case 6:
				newmap = PartCountClockWRotation(nmap,N,M);
				break;
			}
		}
		for(int i=1;i<newmap.length;i++) {
			for(int j=1;j<newmap[0].length;j++) {
				System.out.print(newmap[i][j]+" ");
			}
			System.out.println();
		}
		

	}

	private static int[][] PartCountClockWRotation(int[][] map,int N,int M) {

		int[] dr = { 0, N / 2, 0, -N / 2 };
		int[] dc = { -M / 2, 0, M / 2, 0 };
		int[][] newMap = new int[N + 1][M + 1];

		int startR = 1;
		int startC = M / 2 + 1;

		for (int part = 0; part < 4; part++) {

			if (part > 0) {
				startR += dr[part - 1];
				startC += dc[part - 1];
			}
			for (int i = startR; i < startR + N / 2; i++) {
				for (int j = startC; j < startC + M / 2; j++) {

					newMap[i + dr[part]][j + dc[part]] = map[i][j];
				}
			}

		}
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= M; j++) {
//				System.out.print(newMap[i][j] + " ");
//			}
//			System.out.println();
//		}
		return newMap;

	}

	private static int[][] PartClockWRotation(int[][] map,int N,int M) {
		int[] dr = { 0, N / 2, 0, -N / 2 };
		int[] dc = { M / 2, 0, -M / 2, 0 };
		int[][] newMap = new int[N + 1][M + 1];

		int startR = 1;
		int startC = 1;
		int part = 0;
		while (true) {
			// 두번째 파트부터 델타 적용
			if (part > 0) {
				startR += dr[part - 1];
				startC += dc[part - 1];
			}
			for (int i = startR; i <= startR + N / 2 - 1; i++) {
				for (int j = startC; j <= startC + M / 2 - 1; j++) {
					newMap[i + dr[part]][j + dc[part]] = map[i][j];
				}
			}
			part++;
			// 부분을 4번 반복했으면 break
			if (part == 4)
				break;

		}
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= M; j++) {
//				System.out.print(newMap[i][j] + " ");
//			}
//			System.out.println();
//		}
		return newMap;

	}

	private static int[][] LeftRotation(int[][] map,int N,int M) {
		Queue<Integer> q = new LinkedList<Integer>();
		int[][] rmap = new int[M + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				q.offer(map[i][j]);
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = M; j >= 1; j--) {
				rmap[j][i] = q.poll();
			}
		}
//		for (int i = 1; i <= M; i++) {
//			for (int j = 1; j <= N; j++) {
//				System.out.print(rmap[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		return rmap;

	}

	private static int[][] RightRotation(int[][] map,int N,int M) {
		Queue<Integer> q = new LinkedList<Integer>();
		int[][] rmap = new int[M + 1][N + 1];
		for (int i = 1; i <= M; i++) {
			for (int j = N; j >= 1; j--) {
				q.offer(map[j][i]);
			}
		}
		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= N; j++) {
				rmap[i][j] = q.poll();
			}
		}
//		for (int i = 1; i <= M; i++) {
//			for (int j = 1; j <= N; j++) {
//				System.out.print(rmap[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		return rmap;

	}

	private static int[][] LeftRight(int[][] map,int N,int M) {
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= N; j++) {

				q.add(map[j][i]);

			}
		}
		for (int i = M; i >= 1; i--) {
			for (int j = 1; j <= N; j++) {
				map[j][i] = q.poll();
			}
		}
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		return map;

	}

	private static int[][] UpDown(int[][] map,int N,int M) {

		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {

				q.add(map[i][j]);

			}
		}

		for (int i = N; i >= 1; i--) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = q.poll();
			}
		}
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		return map;

	}

}
