package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ4991_로봇청소기 {
	// 먼지 있는 곳 장소 , 청소기 위치 전부 찾기
	// 순열로 먼지 처리 순서 정하여 모두 처리해보기 -> min 찾기
	// 큐에 위치, 처리한 먼지 개수, 이동거리 저장
	// 전부 처리가 끝났을 때 이동거리의 최소 값 저장
	// 만약 먼지가 이동할 수 없는 위치에 있을 경우 바로 -1 출력
	// 청소기의 이동은 bfs로 구하기

	// 1<=W,H<=20
	static int W;
	static int H;
	static char[][] map;
	static int startX, startY;
	static int distanceMin;
	static boolean[] visitedDust;
	static boolean[][] visitedMap;
	static LinkedList<int[]> dustXY;
	static int[][] disMatrix;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		 StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while(true) {

			st = new StringTokenizer(in.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
//			System.out.println("W H : "+W+" "+H);
			if(W==0 && H==0)break;
			map = new char[H][W];
			dustXY = new LinkedList<>();
			int dustCnt = 1;
			for (int i = 0; i < H; i++) {
				char[] ch = in.readLine().toCharArray();
				for (int j = 0; j < W; j++) {
					map[i][j] = ch[j];
//					System.out.print(map[i][j]);
					if (map[i][j] == '*') {
						map[i][j] = (char) (dustCnt + '0');
						dustCnt++;
						dustXY.offer(new int[] { i, j });
					} else if (map[i][j] == 'o') {
						dustXY.addFirst(new int[] { i, j });
					}
				}
//				System.out.println();
			}

			// 먼지 개수 = 리스트 크기
			// 순열로 순서 정하기
			int numOfTarget = dustXY.size(); // 먼지 개수 + 청소기
			distanceMin = Integer.MAX_VALUE;

			disMatrix = new int[numOfTarget][numOfTarget];
			int i = 0;
			for (; i < numOfTarget; i++) {
				// 청소기 -> 먼지 1 -> 먼지 2 -> ... 순으로
				// 청소기에서 먼지 1,2,3 까지의 거리 각각 구하고
				// 먼지 1에서 청소기, 먼지2, 3 까지 거리 구하기
				visitedMap = new boolean[H][W];
				visitedDust = new boolean[numOfTarget];
				visitedDust[i] = true;
				if (i == 0) {
					// 청소기 일때 먼지들만 찾으면 됨
//					System.out.println("먼지 개수 :"+(dustXY.size() - 1));
					if (!searchDistance(dustXY.size() - 1, dustXY.get(i)[0], dustXY.get(i)[1], i)) {
//						System.out.println("du1");
						break;
					}

				} else {
					// 먼지 일때 자신 빼고 먼지들만 찾으면 됨
					if (!searchDistance(dustXY.size() - 2, dustXY.get(i)[0], dustXY.get(i)[1], i)) {
//						System.out.println("du2");
						break;
					}
				}
			}
			if (i != numOfTarget) {
				sb.append(-1).append("\n");
			}else {
				// 청소기부터 먼지 순서를 순열로 정해서 거리 구하기
				visitedDust = new boolean[numOfTarget];
				permutation(0, 0, 0);
				sb.append(distanceMin).append("\n");
			}


//		for (int[] a : disMatrix) {
//			for (int b : a) {
//				System.out.print(b);
//			}
//			System.out.println();
//		}
		}
		System.out.println(sb);
//		st = new StringTokenizer(in.readLine());
////		System.out.println("durlsms?");
//		System.out.println(st.nextToken()+" "+st.nextToken());
	}

	// 먼지를 찾을 때마다 bfs로 경로찾기
	private static boolean searchDistance(int targetCnt, int startR, int startC, int idx) {
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { startR, startC, 0 });
		int cnt = 0;
		while (!q.isEmpty()) {
			int nowR = q.peek()[0];
			int nowC = q.peek()[1];
			int nowDis = q.poll()[2];
//			System.out.println("현재 위치 : "+"x : "+nowR+" y : "+nowC);
			if (map[nowR][nowC] != '.' && map[nowR][nowC] != 'x' && map[nowR][nowC] != 'o'
					&& !visitedDust[map[nowR][nowC] - '0']) { // 먼지를 찾으면 그떄까지 이동한 거리를 disMatrix에 저장
				int to = map[nowR][nowC] - '0';
				disMatrix[idx][to] = nowDis;
				disMatrix[to][idx] = nowDis;
				visitedDust[to] = true;
				cnt++;

			}

			for (int i = 0; i < 4; i++) {
				int nx = nowR + dx[i];
				int ny = nowC + dy[i];
				if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] != 'x' && !visitedMap[nx][ny]) {
					visitedMap[nx][ny] = true;
					q.offer(new int[] { nx, ny, nowDis + 1 });
				}
			}
		}
		if (cnt < targetCnt) {
			return false;
		}
		return true;
	}

	// 찾아갈 먼지 순서 정하기 순열
	private static void permutation(int searchCnt, int distance, int from) {
		if (searchCnt == dustXY.size() - 1) {
//			System.out.println("총 거리 : " + distance);
			distanceMin = Math.min(distanceMin, distance);
			return;
		}
		for (int i = 1; i < dustXY.size(); i++) {
			if (visitedDust[i])
				continue;
			visitedDust[i] = true;
//			System.out.println("현재 찾을 먼지 : " + dustXY.get(i)[0] + " " + dustXY.get(i)[1]);
//			System.out.println("찾은 먼지 개수는 " + dustCnt);

//			System.out.println("움직인 거리 : " + plusDis);
//			System.out.println("현재 위치에서 먼지까기 거리 : "+disMatrix[from][i]);

			permutation(searchCnt + 1, distance + disMatrix[from][i], i);
			visitedDust[i] = false;
		}
	}

}
