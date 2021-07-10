package com.algo.programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class 다리를지나는트럭 {
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> truck = new LinkedList<>();
		// bridge_length
		// weight
		// truck_weights
		
		int bridge_length = 100;
		int weight = 100;
//		int[] truck_weights = {7,4,5,6};
//		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
		int[] truck_weights = {10};
		
		for(int i=0;i<truck_weights.length;i++) {
			truck.add(truck_weights[i]);
		}
		
		int sec = 0;
		int onW = 0;
		for(int i=1;i<=bridge_length;i++) {
			q.add(0);
		}
		while(!truck.isEmpty()) {
			onW-=q.poll();
			if(onW+truck.peek()<=weight) {
				onW+=truck.peek();
				q.add(truck.poll());

			}else {
				q.add(0);
			}
			sec++;
		}
		while(!q.isEmpty()) {
			q.poll();
			sec++;
		}
		
		System.out.println(aaa());
	}
	public static int aaa() {
		int a =100;
		int answer = 1;
		return answer =a;
	}

}
