package com.algo.programmers;

import java.util.Stack;

public class 크레인인형뽑기게임 {

	public static void main(String[] args) {

		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };

		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };

		System.out.println(Solution(board, moves));
	}

	public static int Solution(int[][] board, int[] moves) {

		int answer = 0;

		Stack<Integer> stack = new Stack<>(); // 뽑은 인형 투입

		int leng = board.length; // row 길이
		int leng1 = board[0].length; // col 길이

		// 인형 뽑기
		for (int i = 0; i < moves.length; i++) {

			int idx = 0;
			int col = moves[i] - 1;

			while (idx<leng) {
				
				if (!(board[idx][col] == 0)) {

					if (stack.isEmpty()) {
						stack.push(board[idx][col]);
						board[idx][col] = 0;
						break;
					}else {
						if(stack.peek()==board[idx][col]) {
							stack.pop();
							board[idx][col]=0;
							answer+=2;
							break;
						}else {
							stack.push(board[idx][col]);
							board[idx][col] = 0;

							break;
						}
					}
				}else {
					
					idx++; // 없으면 내려가서 뽑기
				}


			}
		}

		return answer;
	}

}
