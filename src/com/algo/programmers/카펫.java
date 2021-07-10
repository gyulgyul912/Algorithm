package com.algo.programmers;
import java.util.Arrays;

public class 카펫 {
	
	public static void main(String[] args) {
		solution(24,24);
	}
	public static int[] solution(int brown, int yellow) {

        int[] answer = {};
        	int a=0;
        	int sum = brown+yellow;
        	int product = 0; // (garo+2)(sero+2)
        	int garo=0;
        	int sero=0;
        	for(int i=1;i<=yellow-a;i++) {
        		if(yellow%i==0) {
        			garo=i;
        			sero=yellow/i;
        			product=(garo+2)*(sero+2);
        			if(sum==product)
        				break;
        		}
        		
        	}
        	answer= new int[2];
        	answer[0]= Math.max(garo, sero)+2;
        	answer[1]= Math.min(garo, sero)+2;
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
