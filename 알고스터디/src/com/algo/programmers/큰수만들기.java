package com.algo.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class 큰수만들기 {
	static char[] selected;
	public static void main(String[] args) {
//		String number = "4177252841";
//		String number = "1231234";
//		String number = "101010101010";
		String number = "1111111";
		
		int k = 2;	
		solution(number,k);
	}
	private static void solution(String number, int k) {
		StringBuilder sb = new StringBuilder();
		   char[] ch = number.toCharArray();
			int size = ch.length-k;
			Stack<Character> l = new Stack<>();
			int i=0;
			System.out.println(size);
			System.out.println(Arrays.toString(ch));
			for(;i<ch.length;i++) {
				// 비어있을 경우 그냥 저장
				if(l.isEmpty()) {
					l.add(ch[i]);
				}
				// 남은 수  > 남은 저장 공간
				// 대소 비교 후 저장 or 뺴내기 가능
				else if(ch.length-i>(size-l.size())){
					// 제일 마지막 수 >= 담으려는 수
					if(l.peek()>=ch[i]) {
						l.add(ch[i]);
						System.out.println(i);
						System.out.println(ch[i]);
					}
					// 제일 마지막 수 < 담으려는 수 -> 제일 마지막 수 빼내기				
					else{
						l.pop();
						// 빼낸 후 마지막 수의 위치를 위한 작업
						i--;
						continue;
					}
				}
				// 남은 공간 = 남은 수
				else {
					break;
				}
			}
			while(i<ch.length) {
				l.add(ch[i]);
				i++;
			}
			char[] answers = new char[l.size()];
			for(int a=0;a<size;a++) {
				answers[a] = l.get(a);
				sb.append(answers[a]);
			}
			System.out.println(sb);
		
		
	}

}
