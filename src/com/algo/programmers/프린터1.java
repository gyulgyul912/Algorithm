package com.algo.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 프린터1 {
	public static void main(String[] args) {
		
		int[] priorities = {1,1,9,1,1,1};
		int location = 0;
		LinkedList<int[]> list = new LinkedList();
		int[][] pl = new int[priorities.length][2];
		
		for(int i=0;i<pl.length;i++) {
			pl[i][0] = priorities[i];
			pl[i][1] = i;
			list.add(pl[i]);
		}
		int print = 0;
		while(true) {
			int i=1;
			for(;i<list.size();i++) {
				if(list.get(0)[0]<list.get(i)[0]) {
					list.add(list.remove());
					break;
				}
			}
			if(list.size() == i) {
				print++;
				if(list.peek()[1]==location) break;
				list.remove();
			}
			
		}

	}

}
