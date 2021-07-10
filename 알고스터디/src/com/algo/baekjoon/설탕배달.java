package com.algo.baekjoon;

import java.util.Scanner;

public class 설탕배달 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int w = sc.nextInt();

		int x = w / 5;
		int r = w % 5;
		int y = r/3;
		r = r%3;

		if (r == 0) {
			System.out.println(x+y);
		} else {
			for (x = x - 1; x >= 0; x--) {
				r += 5;
				if (r % 3 == 0) {
					y += r / 3;
					System.out.println(x + y);
					break;
				}
			}
			if (x < 0)
				System.out.println("-1");
		}

	}

}

//import java.io.*;
//import java.util.*;
//
//import javax.swing.plaf.synth.SynthSplitPaneUI;
//
//public class 설탕배달 {
//	
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		
//		int N = Integer.parseInt(in.readLine());
//		
//		int three = 0;
//		int five = 0;
//		
//		for(five = N/5; five >= 0; five--) {
//			int temp = N - five*5;
//			if(temp % 3 == 0) {
//				three = temp / 3;
//				break;
//			}
//		}
//		System.out.println(five);
//		System.out.println((three + five));
//	}
//}
