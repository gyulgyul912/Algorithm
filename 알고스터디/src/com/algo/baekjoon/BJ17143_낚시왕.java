package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ17143_낚시왕 {
	static int R, C, M;
	static Shark[][] map;
	static Shark[][] copyMap;
	static Shark[] sharks;

	static public class Shark {
		int num;
		int r;
		int c;
		int speed;
		int direction;
		int size;

		public Shark(int num, int r, int c, int speed, int direction, int size) {
			super();
			this.num = num;
			this.r = r;
			this.c = c;
			this.speed = speed;
			this.direction = direction;
			this.size = size;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new Shark[R + 1][C + 1];
		sharks = new Shark[M + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());

			map[r][c] = new Shark(i + 1, r, c, speed, direction, size);
			sharks[i + 1] = map[r][c];

		}

		// 낚시 시작
		int personR = 0;
		int personC = 1;
		int totalCatchSize = 0;
		copyMap = new Shark[R + 1][C + 1];
		copyMap = map;
		while (personC <= C) {
			for (int r = 1; r <= R; r++) {
				if (copyMap[r][personC] != null) {
					Shark shark = copyMap[r][personC];
					totalCatchSize += shark.size;
					int num = copyMap[r][personC].num;
					copyMap[r][personC] = null;
					sharks[num] = null;
					break;
				}
			}
//			System.out.println("상어 잡았을 때");
//			for (Shark[] s : copyMap) {
//				for (Shark sk : s) {
//					if (sk != null)
//						System.out.print(sk.r + " " + sk.c + " " + sk.speed + "\n");
//				}
//			}
//			System.out.println();
			// 상어 이동
			System.out.println(totalCatchSize);
			copyMap = moveShark(copyMap);
			// 낚시왕 다음 위치로 이동
			personC++;
		}
		System.out.println(totalCatchSize);
	}

	private static Shark[][] moveShark(Shark[][] nowMap) {
		System.out.println("\n시작 전 상어 위치 ================================================");
		for (Shark[] s : nowMap) {
			for (Shark sk : s) {
				if (sk != null)
					System.out.println("상어 위치 :" + sk.r + " " + sk.c + "\n 스피드, 방향, 사이즈  : " + sk.speed + " "
							+ sk.direction + " " + sk.size);
			}
		}
		System.out.println();
		System.out.println("상어 배열 저장 ==============");
		for (Shark ss : sharks) {
			if (ss != null)
				System.out.println("상어 위치 :" + ss.r + " " + ss.c + "\n 스피드, 방향, 사이즈  : " + ss.speed + " " + ss.direction
						+ " " + ss.size);
		}
		Shark[][] newMap = new Shark[R + 1][C + 1];
		int[] dr = { 0, -1, 1, 0, 0 };
		int[] dc = { 0, 0, 0, 1, -1 };
		for (int i = 0; i < M+1; i++) {
			Shark sks = sharks[i];
			if (sks != null) {
				Shark sk = sks;
				int nr = sk.r;
				int nc = sk.c;
				int nspeed = sk.speed;
				//
				System.out.println("상어 시작 =========================");
				System.out.println("처음 상어 위치 : " + sk.r + " " + sk.c);
				System.out.println("방향 : " + sk.direction);
				while (nspeed > 0) {
					System.out.println("nr nc : " + nr + " " + nc);
					System.out.println("남은 스피드 : " + nspeed);
					if (sk.direction == 1) {
						if (nr < 2) {
							sk.direction = 2;
						}
					} else if (sk.direction == 2) {

						if (nr > R - 1) {
//								System.out.println("여기를 못 들ㅇ오는가냐");
							sk.direction = 1;
						}

					} else if (sk.direction == 3) {
						if (nc > C - 1) {
							sk.direction = 4;
						}

					} else if (sk.direction == 4) {
						if (nc < 2) {
							sk.direction = 3;
						}

					}
					nr += dr[sk.direction];
					nc += dc[sk.direction];
					nspeed--;
				}
//				System.out.println("최종 상어 위치 :" + nr + " " + nc + "\n 스피드, 방향, 사이즈  : " + sk.speed + " " + sk.direction
//						+ " " + sk.size);
				if (newMap[nr][nc] == null) {
					newMap[nr][nc] = new Shark(sharks[i].num, nr, nc, sk.speed, sk.direction, sk.size);
					sharks[i] = newMap[nr][nc];
				} else {
					Shark nowShark = newMap[nr][nc];
					Shark afterShark = new Shark(sharks[i].num, nr, nc, sk.speed, sk.direction, sk.size);
					newMap[nr][nc] = nowShark.size > afterShark.size ? nowShark : afterShark;
					sharks[i] = newMap[nr][nc];
				}
			}
		}
//		System.out.println("\n 상어 이동 후 ========");
//		for (
//
//		Shark[] s : newMap) {
//			for (Shark sk : s) {
//				if (sk != null)
//					System.out.println("최종 상어 위치 :" + sk.r + " " + sk.c + "\n 스피드, 방향, 사이즈  : " + sk.speed + " "
//							+ sk.direction + " " + sk.size);
//			}
//		}
//		System.out.println();
		return newMap;
	}

}
//for(Shark[] s : map) {
//for(Shark sk : s) {
//	if(sk!=null)
//	System.out.print(sk.r+" "+sk.c+" "+sk.speed+"\n");
//}
//}
