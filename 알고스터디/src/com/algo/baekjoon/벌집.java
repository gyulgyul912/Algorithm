package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 벌집 {
	public static void main(String[] args) throws IOException, NumberFormatException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(in.readLine());
		

		int cnt = 0;
		int b = 1;
		boolean flag = false;
		if(num==b) {
			cnt=1;
			flag = true;
		}
		else {
			b++;
			cnt++;
		}
		int a=0;
		int c = 0;

		while(!flag) {
			cnt++;
			b = b+6*a;
			c = b+(6*(a+1)-1);
			if(b<=num && num<=c) {
				break;
			}
			a++;
		}
		System.out.println(cnt);
	}

}
