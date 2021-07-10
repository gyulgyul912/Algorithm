package com.algo.programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 더맵게 {
	
	public static void main(String[] args) {
//		int[] scoville = {1,2,3,9,10,12};
		int[] scoville = {1,2};
//		int[] scoville = {10,10,10,10,10};
		int k = 6;
		System.out.println(solution(scoville,k));
		
	}
    static public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0;i<scoville.length;i++) {
        	pq.add(scoville[i]);
        }
        
        while(pq.peek()<K && pq.size()>=2) {
        	int first = pq.poll();
        	int second = pq.poll();
        	pq.add(first+second*2);       	
        	answer++;       	
        }
        if(pq.peek()<K) {
        	return -1;
        }
        return answer;
    }

}
