package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class 참외밭 {

	
	public static void main(String[] args) throws IOException,NumberFormatException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int chamoe = Integer.parseInt(in.readLine());		
		int[][] round = new int[6][2];	
		int[] cnt = new int[6];
		int[] cnt2 = new int[2];
		int a = 0;
		for(int i=0;i<6;i++) {
			String[] str = in.readLine().split(" ");
				round[i][0] = Integer.parseInt(str[0]);
				round[i][1] = Integer.parseInt(str[1]);
				cnt[round[i][0]]++;	// 방향의 개수 저장. 2개 나오면 잘린 부분
				if(cnt[round[i][0]]==2) {
					cnt2[a++] = round[i][0];	// 두개면 방향 저장	ts 3 1
				}
		}
		int[][] beun = new int[2][2];	// 전체 변 두개 저장
		a =0;
		int[] smallBeun = new int[2];	// 잘린 변 두개 저장
		for(int i=0;i<6;i++) {
			// 한개의 방향만 나온 변 찾기
			if(round[i][0] !=cnt2[0] && round[i][0] != cnt2[1]) {
				beun[a][0] = i;
				beun[a++][1] = round[i][1];
			}
			// 변 두개 찾으면 
			if(a==2 && beun[0][0] == 0 && beun[1][0] == 5) {
				smallBeun[0] = round[(i+3)%6][1];
				smallBeun[1] = round[(i+4)%6][1];
				break;
			}
			else if(a==2) {		
				smallBeun[0] = round[(i+2)%6][1];
				smallBeun[1] = round[(i+3)%6][1];
				break;
			}
		}
//		System.out.println(smallBeun[0]+ " "+smallBeun[1]);
//		
//		System.out.println(beun[0]+" "+beun[1]);
		System.out.println(chamoe*(Math.abs((beun[0][1]*beun[1][1])-(smallBeun[0]*smallBeun[1]))));
	
	}
}
