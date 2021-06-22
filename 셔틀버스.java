package com.algo.programmers;

import java.util.Arrays;

public class 셔틀버스 {

	public static void main(String[] args) {
//		int n = 1;
//		int t = 1;
//		int m = 5;
//		String[] timetable = { "08:00", "08:01", "08:02", "08:03" };
//		int n = 2;
//		int t = 10;
//		int m = 2;
//		String[] timetable = {"09:10","09:09", "08:00"};
		int n = 2;
		int t = 1;
		int m = 2;
		String[] timetable = {"09:00", "09:00", "09:00", "09:00"};

//		int n = 10;
//		int t = 60;
//		int m = 45;
//		String[] timetable = {"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};
		String ans = Solution(n, t, m, timetable);
		System.out.println(ans);
	}

	private static String Solution(int n, int t, int m, String[] timetable) {
		String answer = "";
		String[] shuttle = new String[n];
		String busTime = "09:";
		Arrays.sort(timetable);
		int hour = 9;
		int plus = 0;
		for (int i = 0; i < n; i++) {
			String bus = "";
			int interval = i * t;
			if (plus > 0) {
				interval -= 60 * plus;
			}
			if (interval < 10)
				bus = busTime + "0" + interval;
			else {
				if (interval >= 60) {
					hour += 1;
					busTime = hour + ":";
					bus = busTime + "00";
					plus++;
				} else {
					bus = busTime + interval;
				}
			}
			shuttle[i] = bus;
		}

		// 태우기
		int crewIdx = 0;
		for (int i = 0; i < shuttle.length; i++) {
			String[] nowBus = shuttle[i].split(":");
			int nowBusHr = Integer.parseInt(nowBus[0]);
			int nowBusMin = Integer.parseInt(nowBus[1]);
			String[] crew = new String[2];
			int crewHr = 0;
			int crewMin = 0;
			if (i < shuttle.length - 1) {
				crew = timetable[crewIdx].split(":");
				crewHr = Integer.parseInt(crew[0]);
				crewMin = Integer.parseInt(crew[1]);
				while (nowBusHr > crewHr || (nowBusHr == crewHr && nowBusMin >= crewMin)) {
					crewIdx++;
					crew = timetable[crewIdx].split(":");
					crewHr = Integer.parseInt(crew[0]);
					crewMin = Integer.parseInt(crew[1]);
				}
			} else {
				crew = timetable[crewIdx].split(":");
				crewHr = Integer.parseInt(crew[0]);
				crewMin = Integer.parseInt(crew[1]);
				if(nowBusHr < crewHr
						|| (nowBusHr == crewHr && nowBusMin < crewMin)){
					answer+=shuttle[i];
					break;
				}
				// 버스 도착시간보다 먼저 대기하는 인원 찾기
				while (crewIdx < timetable.length && crewIdx < crewIdx + m && nowBusHr > crewHr
						|| (nowBusHr == crewHr && nowBusMin > crewMin)) {
					crewIdx++;
					crew = timetable[crewIdx-1].split(":");
					crewHr = Integer.parseInt(crew[0]);
					crewMin = Integer.parseInt(crew[1]);
				}

				if(nowBusHr>crewHr ||(nowBusHr==crewHr && nowBusMin>crewMin)) {					
					answer+=shuttle[i];
				}else {				
					answer += timetable[crewIdx-2];
				}


			}
		}
		return answer;
	}

}
