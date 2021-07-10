package com.algo.programmers;

import java.util.Arrays;

public class 단속카메라 {

	public static void main(String[] args) {

		int[][] routes = { { -20, 15 }, { -14, -5 }, { -18, -13 }, { -5, -3 }};

		solution(routes);
	}

	private static void solution(int[][] routes) {
		//				  stand
		//					 ▽
		// ----------------- 1
		//
		//          ---------------- 2
		//                      ------------------- 3
		//                        ------------4
		//                                              ------5
		Arrays.sort(routes, (a,b)-> Integer.compare(a[1], b[1])); // 오름차순 정렬
		
		int cameraCnt = 0;
		int stand = routes[0][1];
		cameraCnt+=1;
		for(int i=1;i<routes.length;i++) {
			if(stand<routes[i][0]) {
				stand = routes[i][1];
				cameraCnt++;
			}	
		}
		System.out.println(cameraCnt);
	}

}
