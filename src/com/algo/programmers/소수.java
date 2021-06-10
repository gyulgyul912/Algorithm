package com.algo.programmers;

import java.io.IOException;
import java.util.LinkedList;

public class 소수 {
	
	static boolean isSelected[];
	static char[] ch;
	static int sosuCnt;
	static LinkedList<String> complete = new LinkedList<>();
	static int idx;
	public static void main(String[] args) throws IOException, NumberFormatException {
		
		String sosu = "011";
		ch = sosu.toCharArray();
		isSelected = new boolean[ch.length];
		sosuCnt = 0;
		for(int i=1;i<=ch.length;i++) {
			char[] c = new char[i];
			permutation(i,0,ch.length,c);
		}
		System.out.println(sosuCnt);
	}

	private static void permutation(int n,int cnt,int size,char[] c) {
		if(cnt==n) {
			for(int i=0;i<c.length;i++) {
				System.out.print(c[i]+" ");
			}
			System.out.println();
			String num = new String(c);
			if(num.charAt(0) == '0' ||complete.contains(num) )return;
			int checksosu = Integer.parseInt(num);
			if(checksosu==1) return;
			complete.add(num);		
			if(isitSosu(checksosu)) sosuCnt++;
			return;
		}
		for(int i=0;i<size;i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			c[cnt]=ch[i];
			permutation(n, cnt+1, size,c);
			isSelected[i] = false;
			c[cnt] = ' ';
		
		}
		
	}

	private static boolean isitSosu(int c) {
		double root = Math.sqrt(c);
		System.out.println(complete);
		for(int i=2;i<=root;i++) {
			if(c%i==0) {
				return false;
			}
		}
		return true;
		
	}

}
