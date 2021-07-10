package com.algo.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 기능개발 {
	
	public static void main(String[] args) {
		
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		int[] days = new int[speeds.length];
		int[] answers = {};
		for(int i=0;i<progresses.length;i++) {
			int n = 0;
			while(progresses[i]+speeds[i]*n<100) {
				n++;
			}
			days[i] = n;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0;i<days.length;) {
			
			int cnt=1;
			while((i+cnt)<days.length && days[i]>days[i+cnt]) {
				cnt++;
			}
			q.add(cnt);
			i+=cnt;
		}
		answers = new int[q.size()];
		for(int i=0;i<answers.length;i++) {
			answers[i] = q.poll();
		}
		System.out.println(Arrays.toString(answers));

	}

}
