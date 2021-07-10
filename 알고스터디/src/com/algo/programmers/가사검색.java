package com.algo.programmers;

public class 가사검색 {

	public static void main(String[] args) {

		String[] words = { "frodo", "front", "frost", "frozen", "frame", "kakao" };
		String[] queries = { "fro??", "????o", "fr???", "fro???", "pro?" };
		int[] ans = Solution(words, queries);
		for (int a : ans)
			System.out.print(a + " ");
	}

	private static int[] Solution(String[] words, String[] queries) {
		int querySize = queries.length;
		int wordSize = words.length;
		int[] answer = new int[querySize];
		for (int i = 0; i < querySize; i++) {
			char[] querych = queries[i].toCharArray();
			int qchSize = querych.length;
			for (int j = 0; j < wordSize; j++) {
				char[] wordch = words[j].toCharArray();
				int wchSize = wordch.length;

				if (qchSize == wchSize) {
					int k = 0;
					int k2 = qchSize-1;
					boolean flag = true;
					for (; k <=k2; k++,k2--) {
						if (querych[k2] != '?' && wordch[k2] != querych[k2]) {
							flag = false;
							break;
						}
						if (querych[k] != '?' && wordch[k] != querych[k]) {
							flag = false;
							break;
						}

//						if (querych[k] == '?' || wordch[k] == querych[k]) {
//							continue;
//						}
//						break;
					}
//					System.out.println(queries[i]+" "+words[j]);
					if (flag)
						answer[i]++;
//					System.out.println(answer[i]);
				}
			}
		}
		return answer;

	}

}
