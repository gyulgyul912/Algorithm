package com.algo.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 여행경로 {
	static public class Node {
		String city;
		int usedTicketsNum;
		boolean[] visited;
		LinkedList<String> route;

		public Node(String city, int usedTicketsNum, boolean[] visited, LinkedList<String> route) {
			super();
			this.city = city;
			this.usedTicketsNum = usedTicketsNum;
			this.visited = visited;
			this.route = route;
		}

	}

	public static void main(String[] args) {
//		String[][] tickets = { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } };
		String[][] tickets = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" },
				{ "ATL", "SFO" } };

		solution(tickets);
	}

	private static String[] solution(String[][] tickets) {
		String[] answer = {};
		LinkedList<String[]> list = new LinkedList<>();
		for (int i = 0; i < tickets.length; i++) {
			if (tickets[i][0].equals("ICN")) {
				list.addFirst(tickets[i]);
			} else {
				list.addLast(tickets[i]);
			}
		}
		// BFS
		Queue<Node> q = new LinkedList<Node>();
		boolean[] visited = new boolean[tickets.length];
		LinkedList<String> route = new LinkedList<>();
		route.add("ICN");
		q.offer(new Node("ICN", 0, visited, route));
		LinkedList<String> ans = new LinkedList<>();
		while (!q.isEmpty()) {
			Node n = q.poll();
			if (n.usedTicketsNum == tickets.length) {
				if (ans.size() == 0) {
					ans = n.route;
				} else {
					for (int i = 0; i < ans.size(); i++) {
						if (ans.get(i).compareTo(n.route.get(i)) > 0) {
							ans = n.route;
							break;
						}else if(ans.get(i).compareTo(n.route.get(i)) < 0) {
							break;
						}
					}
				}

			}
			for (int i = 0; i < tickets.length; i++) {
				if (!n.visited[i] && n.usedTicketsNum <= tickets.length && tickets[i][0].equals(n.city)) {
					boolean[] newVisited = new boolean[tickets.length];
					for (int j = 0; j < n.visited.length; j++) {
						newVisited[j] = n.visited[j];
					}
					newVisited[i] = true;

					LinkedList<String> newRoute = new LinkedList<>();
					for (int k = 0; k < n.route.size(); k++) {
						newRoute.add(n.route.get(k));
					}
					newRoute.add(tickets[i][1]);
					q.offer(new Node(tickets[i][1], n.usedTicketsNum + 1, newVisited, newRoute));
				}
			}
		}
		answer = new String[ans.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = ans.get(i);
			System.out.print(answer[i] + " ");
		}
		return answer;
	}
}
