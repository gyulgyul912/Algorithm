package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1193분수찾기 {
	
	public static void main(String[] args)throws IOException, NumberFormatException {
		
		
		BufferedReader in = new BufferedReader(new FileReader("C:\\SSAFY\\workspace\\web\\02 algo\\src\\input (1).txt"));
		
		while(true) {
			String line = in.readLine();
			if(line==null)break;
			System.out.println(line);
		}
		in.close();
	}

}
