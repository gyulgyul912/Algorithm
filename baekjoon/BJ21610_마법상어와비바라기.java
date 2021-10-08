package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ21610_마법상어와비바라기 {
    static int[] dr = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {0, -1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        Queue<int[]> cloud = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 구름 위치 저장
        cloud.add(new int[]{N - 1, 0});
        cloud.add(new int[]{N - 1, 1});
        cloud.add(new int[]{N - 2, 0});
        cloud.add(new int[]{N - 2, 1});

        // 구름 이동
        for (int i = 0; i < M; i++) {
            // 1번째
            st = new StringTokenizer(in.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int move = Integer.parseInt(st.nextToken());
            int cloudCnt = cloud.size();
            for (int j = 0; j < cloudCnt; j++) {
                int[] nowCloud = cloud.poll();
                for (int k = 0; k < move; k++) {
                    if (nowCloud[0] + dr[dir] == -1) {
                        nowCloud[0] = N - 1;
                    } else if (nowCloud[0] + dr[dir] == N) {
                        nowCloud[0] = 0;
                    } else if (nowCloud[1] + dc[dir] == -1) {
                        nowCloud[1] = N - 1;
                    } else if (nowCloud[1] + dc[dir] == N) {
                        nowCloud[1] = 0;
                    } else {
                        nowCloud[0] += dr[dir];
                        nowCloud[1] += dc[dir];
                    }
                }
                cloud.add(new int[]{nowCloud[0], nowCloud[1]});
            }

        }
    }
}
