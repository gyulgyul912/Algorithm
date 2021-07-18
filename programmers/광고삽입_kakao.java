package com.algo.programmers;

import java.util.*;

public class 광고삽입_kakao {
	public static void main(String[] args) {
		String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
		System.out.println(solution("02:03:55","00:14:15",logs));
	}
    public static String solution(String play_time, String adv_time, String[] logs) {
        int playTime = timeToSecond(play_time), advTime = timeToSecond(adv_time);

        long[] playCnt = new long[playTime + 1];
        for (String log : logs) {
            String[] split = log.split("-");
            playCnt[timeToSecond(split[0])]++;
            playCnt[timeToSecond(split[1])]--;
        }

        for (int i = 1; i <= playTime; i++) playCnt[i] += playCnt[i - 1];
        for (int i = 1; i <= playTime; i++) playCnt[i] += playCnt[i - 1];

        long maxTime = playCnt[advTime - 1], maxStartTime = 0;
        for (int i = 0; i + advTime <= playTime; i++) {
            long tmp = playCnt[i + advTime] - playCnt[i];

            if (tmp > maxTime) {
                maxTime = tmp;
                maxStartTime = i + 1;
            }
        }

        return String.format("%02d:%02d:%02d", maxStartTime / (60 * 60), (maxStartTime / 60) % 60, maxStartTime % 60);
    }

    static int timeToSecond(String str) {
        int[] parse = Arrays.stream(str.split(":")).mapToInt(Integer::parseInt).toArray();
        return parse[0] * 60 * 60 + parse[1] * 60 + parse[2];
    }
}
