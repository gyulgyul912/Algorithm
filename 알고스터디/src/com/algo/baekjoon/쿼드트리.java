package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 쿼드트리 {
	static int N;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException, NumberFormatException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(in.readLine());
		
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			String[] str = in.readLine().split("");
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}	
		recursive(0,0,N);
		System.out.println(sb);
	}

	private static void recursive(int x, int y, int size) {
		// 시작 부분부터 같은 값인지 확인
		boolean flag = true;
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				if(map[x][y]!=map[i][j]) {
					flag = false;
					break;
				}
			}
		}
		// 같은 값일 경우 첫번째 값을 출력
		if(flag) {
			sb.append(map[x][y]);
			return;
		}
		// 같지 않아서 부분을 나눠 들어감. 괄호 생성
			size/=2;
			sb.append("(");		
			for(int i=0;i<2;i++) {
				for(int j=0;j<2;j++) {
					recursive(x+i*size,y+j*size,size);
				}
			}			
			sb.append(")");		
		}
	
}
