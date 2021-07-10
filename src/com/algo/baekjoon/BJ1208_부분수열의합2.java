package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ1208_부분수열의합2 {
	static int N,S;
	static long cnt;
	static int[] num;
	static ArrayList<Integer> listR = new ArrayList<>();
	static ArrayList<Integer> listL = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		num = new int[N];
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		// 두 개로 나누어 부분합 구하기
		sumSubset(0,0,N/2,listR);
		sumSubset(0,N/2,N, listL);
		Collections.sort(listR);
		Collections.sort(listL);
		// 두 부분합들의 원소들을 하나는 처음부터 하나는 끝부터 해서 구해주기
		cnt=0;
		searchAns();
		if(S==0)cnt--;
		System.out.println(cnt);
	}
	private static void searchAns() {
		int pointR = 0;
		int pointL = listL.size()-1;
		while(true) {
			if(pointR==listR.size() || pointL<0) {
				break;
			}			
			int valueR = listR.get(pointR);
			int valueL = listL.get(pointL);

			if((valueR+valueL)==S) {
				long sameCntR = 0;
				while(pointR<listR.size() && listR.get(pointR)==valueR) {
					sameCntR++;
					pointR++;
				}
				long sameCntL = 0;
				while(pointL>=0 && listL.get(pointL)==valueL) {
					sameCntL++;
					pointL--;
				}
				cnt+= sameCntR * sameCntL;
			}
			if((valueR+valueL)<S) {
				pointR++;
			}
			if((valueR+valueL)>S) {
				pointL--;
			}
			
		}	
	}
	private static void sumSubset(int sum, int start, int end, ArrayList<Integer> list) {
		if(start == end) {
			list.add(sum);
			return;
		}
		sumSubset(sum+num[start], start+1, end, list);
		sumSubset(sum, start+1, end, list);	
	}

}
