package com.algo.programmers;

public class 문자열압축 {
	public static void main(String[] args) {
		String s = "aabbaccc";
		System.out.println(solution(s));

	}

	private static int solution(String s) {
		int answer = Integer.MAX_VALUE;

		int len = 1;
		while (len <= s.length() / 2) {
			StringBuilder sb = new StringBuilder();
			for (int start = 0; start+len < s.length();) {
				System.out.println("처음 : "+(start+len)+" "+s.length());
				if ((start + len) < s.length()) {
					String now = s.substring(start, start + len);
					int cnt = 1;
					if((start+len*2)<s.length() && now.equals(s.substring(start+len, start+len*2))) {
						cnt++;
						start +=len*2;
					}else {
						if(cnt!=1)sb.append(cnt).append(now);
						else sb.append(now);
						start+=len;
					}	
					System.out.println(start);
					System.out.println(sb);
				}
			}
			System.out.println(sb);
			answer = Math.min(answer, sb.length());
			len++;
		}
		return answer;
	}
}
