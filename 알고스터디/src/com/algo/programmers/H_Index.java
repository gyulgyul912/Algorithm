package com.algo.programmers;

import java.util.Arrays;

public class H_Index {
	
	public static void main(String[] args) {
		
		int[] citations = {1,1,1,2,3,4,5};
		int[] citations1 = {1,2,3,4,5,7};
		Arrays.sort(citations);
		int hMax = 0;
		int size = citations[citations.length-1];
		for(int i=0;i<=size;i++) {
			
			int cnt = 0;

			for(int j=0;j<citations.length;j++) {
				if(i<=citations[j])cnt++;
			}
//			System.out.println(cnt);
//			System.out.println(i);
			if(cnt>=i && ((citations.length-i)<=i)) {
				hMax = hMax > i ? hMax : i;
				System.out.println(hMax);
			}
		}
		
	}

}
