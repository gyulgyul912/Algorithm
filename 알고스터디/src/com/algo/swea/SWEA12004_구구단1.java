package com.algo.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA12004_구구단1 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String a = "12345";
		String b = new String("12345");
		System.out.println(a.equals(b));
		System.out.println(a==b);
		int TC = Integer.parseInt(in.readLine());
		for(int t = 1; t<=TC;t++) {
			int num = Integer.parseInt(in.readLine());
			int i = 1;
			for(;i<=9;i++) {
				if(num%i==0 && num/i>=1 && num/i<=9) {
					System.out.println("#"+t+" "+"Yes");
					break;
				}
			}
			if(i==10) {
				System.out.println("#"+t+" "+"No");
			}
		}
	}

}
