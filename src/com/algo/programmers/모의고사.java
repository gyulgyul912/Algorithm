package com.algo.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 모의고사 {
	
	public static void main(String[] args) {
		
		int[] answer = {1,2,3,4,5};
		System.out.println(solution(answer));
	}
	
	
	public static int[] solution(int[] answers) {
		
        int[] answer = {};
        
        Queue<Integer> q = new LinkedList<Integer>();
        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();
        
        int[] Cnt = new int[3];
        // 1번 맞힌 개수
        // 1번 찍은 것 투입
        for(int i=1;i<=5;i++) {
        	q.add(i);
        }
        for(int k=0;k<answers.length;k++) {
        	if(answers[k]==q.peek()) {
        		Cnt[0]++;
        	}
    		q.add(q.poll());
        }
        // 2번 맞힌 개수
        String str1 = "21232425";
        for(int i=0;i<str1.length();i++) {

        	q1.add(str1.charAt(i)-'0');
        }
        for(int k=0;k<answers.length;k++) {

        	if(answers[k]==q1.peek()) {
        		Cnt[1]++;
        	}
    		q1.add(q1.poll());
        }
        // 3번 맞힌 개수
        String str = "3 3 1 1 2 2 4 4 5 5";
        String[] st1 = str.split(" ");
        int thirdCnt = 0;
        for(int i=0;i<st1.length;i++) {
        	q2.add(Integer.parseInt(st1[i]));
        }
        for(int k=0;k<answers.length;k++) {

        	if(answers[k]==q2.peek()) {
        		Cnt[2]++;
        	}
    		q2.add(q2.poll());
        }
        int[] sortCnt = new int[3];
        for(int i=0;i<3;i++) {
        	sortCnt[i] = Cnt[i];
        }     
        Queue<Integer> q3 = new LinkedList<>();
        Arrays.sort(sortCnt);
        int s = 0;
        for(int i=0;i<3;i++) {
        	if(sortCnt[2]==Cnt[i]) {
        		q3.add(i+1);
        	}
        }
        answer = new int[q3.size()];
        int i=0;
        while(!q3.isEmpty()) {
        	answer[i++] = q3.poll();
        }
        
        return answer;
    }

}





