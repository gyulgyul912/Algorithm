package com.algo.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Sam진법뒤집기 {

	public static void main(String[] args) {

		// 3진법으로 표현
		// 표현할 때 뒤부터 값이 나오기 떄문에
		// Queue 에 넣어주면서
		// 앞뒤 반전
		// 앞에서부터 get()을 해주어
		// 3^n 곱할 때 왼쪽부터 곱하니까3^q.size()-1.... 3^0  10진법으로 표현
		int n = 1;
		int answer = 0;
		Queue<Integer> q = new LinkedList<>();
		// 몫이 1 ,2 가 아닐 때 반복
		int s=0;
		while (true) {
			// 나머지가 3진법 역순으로 나오기 때문에 바로 대입
			q.add(n % 3);
			// 몫으로 다음 연산
			n = n / 3;
			if (n==1 || n==2) {
				q.add(n);
				break;
			}else if(n==0) {
				break;
			}
		}
		// 3진법 -> 10진법 
		// ex. 0121 0*3^3+1*3^1+2*3^2+1*3^0
		// q.size() -> 0
		for (int i = q.size()-1; i >= 0; i--) {
			answer += q.poll() * Math.pow(3, i);
		}
		System.out.println(answer);


	}
}
