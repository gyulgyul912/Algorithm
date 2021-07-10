package com.algo.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {

	public static void main(String[] args) {

		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
//		String[] words = { "hot", "dot", "dog", "lot", "log" };
		solution("hit", "cog", words);
		System.out.println(step);
	}
	static int step;
	public static class Xy {
		String word;
		int step;

		public Xy(String word, int step) {
			super();
			this.word = word;
			this.step = step;
		}
	}

	private static void solution(String begin, String target, String[] words) {

		Queue<Xy> q = new LinkedList<Xy>();
		boolean[] visited = new boolean[words.length];
		q.offer(new Xy(begin, 0));
		while (!q.isEmpty()) {

			String now = q.peek().word;
			int nowStep = q.poll().step;
			if (now.equals(target)) {
				step = nowStep;
				break;
			}
			for (int i = 0; i < words.length; i++) {
				int diff = 0;
				if (visited[i])
					continue;
				for (int j = 0; j < now.length(); j++) {
					if (now.charAt(j) != words[i].charAt(j)) {
						diff++;
					}
				}
				if (diff == 1) {
					q.offer(new Xy(words[i], nowStep + 1));
					visited[i] = true;
				}
			}

		}

	}

}
