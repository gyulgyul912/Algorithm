package com.algo.baekjoon;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class 빙고 {
//	public static void main(String[] args) throws IOException, NumberFormatException {
//
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//
//		StringTokenizer st;
//
//		// 인덱스 1부터 사용
//		int[][] matrix = new int[6][6];
//		// 5 X 5 빙고판
//		for (int i = 1; i <= 5; i++) {
//			st = new StringTokenizer(in.readLine());
//			for (int j = 1; j <= 5; j++) {
//				matrix[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//
//		// 빙고 과정 count
//		// 가로 5개 세로 5개 대각선 2개
//		int[] cnt = new int[13];
//		// 부르는 순서대로 숫자 담기
//		Queue<Integer> q = new LinkedList<Integer>();
//
//		// 빙고 완성
//		for (int a = 1; a <= 5; a++) {
//			st = new StringTokenizer(in.readLine());
//			for (int b = 1; b <= 5; b++) {
//				q.add(Integer.parseInt(st.nextToken()));
//
//			}
//		}
//		int count = 0; // 부른 숫자 개수
//		int bingoCnt = 0; // 빙고된 개수
//		// 빙고판에서 숫자 비교
//
//		while (!q.isEmpty()) {
//			count++; // 부른 숫자 개수 +
//			for (int i = 1; i <= 5; i++) {
//				// 어느 곳에 저장되어 있는지 찾기
//				int j = 1;
//				for (; j <= 5; j++) {
//		//			System.out.println("i: " + i + " j : " + j + " matrix : " + matrix[i][j]);
//					if (matrix[i][j] == q.peek()) {
//
//						cnt[i]++; // 행의 빙고에 +
//						cnt[j + 5]++; // 열의 빙고에 +
//						if (i == j) { // 대각선 빙고에 +
//							cnt[11]++;
//						}
//						if (j == 6 - i) {
//							cnt[12]++;
//						}
//						break;
//					}
//				}
//				if (j != 6)
//					break;
//
//			}
//			// 빙고가 되었는지 확인
//			// 5개 이상 불렀을 때 빙고될 수 있기 때문
//			if (count >= 5) {
//				for (int k = 1; k <= 12; k++) {
//					if (cnt[k] == 5) {
//						cnt[k] -= 5;
//						bingoCnt++;
//					}
//					if (bingoCnt == 3) {
//						break;
//					}
//				}
//			}
//			if (bingoCnt == 3) {
//				System.out.println(bingoCnt);
//				break;
//
//			}
//
//			System.out.println(bingoCnt);
//			q.poll(); // 부른 수 삭제
//		}
//
//	}
//
//}

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class 빙고 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] row = new int[5];
		int[] col = new int[5];
		int[] cross = new int[2];
		
		int[][] board = new int[5][5];
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<5; j++) {
				int num = Integer.parseInt(st.nextToken()) - 1;
				board[num/5][num%5] = i*5+j;
				System.out.print(board[num/5][num%5]+" ");
			}
			System.out.println();
		}
		
		int bingo = 0;
		
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<5; j++) {
				int num = Integer.parseInt(st.nextToken()) - 1;
				num = board[num/5][num%5];

				int a = num / 5;
				int b = num % 5;
				System.out.println("num : "+num);
				System.out.println("a : "+a);
				System.out.println("b : "+b);
				row[a]++;
				col[b]++;
				if(a==b) cross[0]++;
				if(4-a == b) cross[1]++;
				
				if(row[a] == 5) bingo++;
				if(col[b] == 5) bingo++;
				if(a == b && cross[0] == 5) bingo++;
				if(4-a == b && cross[1] == 5) bingo++;
				
				if(bingo >= 3) {
					System.out.println((i*5+j+1));
					return;
				}
			}
		}
	}
}
