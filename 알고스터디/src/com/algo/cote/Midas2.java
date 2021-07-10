package com.algo.cote;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Midas2 {
	
	public static void main(String[] args) {
		int n = 10;
		int[] v1 = {1, 10, 6, 5, 6, 9};
		int[] v2 = {3, 7, 2, 8, 7, 3};
		int[] num = {3, 4, 5, 1, 8, 7, 9, 2};
		int[] amount = {10, 5, 6, -6, -8, 2, -2, 5};
		System.out.println(Solution(n,v1,v2,num,amount));
		
	}
	
	public static class Team{
		int daepyo;
		LinkedList<Integer> persons = new LinkedList<>();
		public Team(int daepyo, LinkedList<Integer> persons) {
			super();
			this.daepyo = daepyo;
			this.persons = persons;
		}
	}
	private static int Solution(int n, int[] v1, int[] v2, int[] num, int[] amount) {
		int answer = 0;
		LinkedList<Team> list = new LinkedList<>();
		// 팀 꾸리기
		LinkedList<Integer> teamList = new LinkedList<>();
		teamList.offer(v1[0]);
		teamList.offer(v2[0]);
		list.offer(new Team(Math.min(v1[0], v2[0]),teamList));
		for(int i=1;i<v1.length;i++) {
			int min = Math.min(v1[i], v2[i]);
			int max = Math.max(v1[i], v2[i]);
			int j = 0;
			int enterTeam = 0;
			for(;j<list.size();j++) {
				LinkedList<Integer> nowPersons = list.get(j).persons;
				int k = 0;
				for(;k<nowPersons.size();k++) {
					if(min==nowPersons.get(k) || max == nowPersons.get(k)) {
						// 같은 팀

						if(min!=nowPersons.get(k)) {
							list.get(j).persons.offer(min);
							list.get(j).daepyo = Math.min(min, list.get(j).daepyo);
						}

						if(max != nowPersons.get(k)) {
							list.get(j).persons.offer(max);
							list.get(j).daepyo = Math.min(min, list.get(j).daepyo);
						}

						enterTeam = 1;
						break;
					}
				}
				if(enterTeam==1)break;
			}
			if(j==list.size()) {
				teamList = new LinkedList<>();
				teamList.offer(min);
				teamList.offer(max);
				list.offer(new Team(min,teamList));
			}
		}
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).daepyo);
		}		
		System.out.println();
        return answer;
	}

}
