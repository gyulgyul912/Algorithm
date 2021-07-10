package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BJ2941_크로아티아알파벳 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		Map<String, String> map = new HashMap<>();

		map.put("c=", "c=");
		map.put("c-", "c-");
		map.put("dz=", "dz=");
		map.put("d-", "d-");
		map.put("lj", "lj");
		map.put("nj", "nj");
		map.put("s=", "s=");
		map.put("z=", "z=");

		int alphabetCnt = 0;

		int idx = 0;
		String words = in.readLine();
		int end = words.length();
		while (idx < end) {
			if ((idx + 2) < end && words.substring(idx, idx + 3).equals(map.get(words.substring(idx, idx + 3)))) {
				idx += 3;
			} else if ((idx + 1) < end
					&& words.substring(idx, idx + 2).equals(map.get(words.substring(idx, idx + 2)))) {

				idx += 2;
			} else {
				idx += 1;
			}
			alphabetCnt++;
		}

		System.out.println(alphabetCnt);
	}

}
