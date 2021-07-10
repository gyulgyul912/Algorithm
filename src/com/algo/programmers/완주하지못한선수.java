package com.algo.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.sun.xml.internal.ws.util.CompletedFuture;

public class 완주하지못한선수 {

	public static void main(String[] args) {

		
		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = {"josipa", "filipa", "marina", "nikola"};
		System.out.println(solution(participant,completion));
		
	}

	public static String solution(String[] participant, String[] completion) {

		Arrays.sort(participant);
		Arrays.sort(completion);
		Queue<String> particiList = new LinkedList<String>();
		Queue<String> compleList = new LinkedList<String>();
		for (String a : participant) {
			particiList.add(a);
		}
		for (String aa : completion) {
			compleList.add(aa);
		}
		String answer = "";


		while(particiList.size()!=1){
			if(particiList.peek().equals(compleList.peek())) {
				particiList.poll();
				compleList.poll();
			}else {
				particiList.add(particiList.poll());
			}
		}
		
		
		return answer = particiList.peek();
	}
}
