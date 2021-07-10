package com.algo.programmers;

public class 조이스틱 {
	
	public static void main(String[] args) {
//		String str= "JEROEN";
		String str = "BBBBAAAABA";
		solution(str);
	}
	public static void solution(String name) {
		char[] ch = name.toCharArray();
		int cnt = 0;	// 초기 값과 다른 개수
		
		for(int i=0;i<ch.length;i++) {
			if(ch[i]!='A')
				cnt++;
		}
		int x = 0; // 현재 위치
		int y = 1; // 양 옆 확인 인덱스
		int min = 0;
		
		while(cnt!=0) {

			if(x==0 && ch[x]!='A') {
				// 어느 방향으로 이동하는게 최소인지 확인
				min+=Math.min(ch[x]-'A', 'Z'+1-ch[x]);
				cnt--;
				ch[x] = 'A';
			}else {
				int idx1 = (x+y) >=(ch.length) ? x : (x+y);
				int idx2 = (x-y)<0 ? ch.length-(y-x) : (x-y);
				
				if(ch[idx2]!='A' && ch[idx1]!='A') { // 양쪽이 모두 A가 아닐 때
					// 오른쪽으로 이동
					min+=Math.abs(idx1-x);
					min+=Math.min(ch[idx1]-'A', 'Z'+1-ch[idx1]);
					
					cnt--;
					y=1;
					x = idx1;
					ch[idx1] = 'A';
				}else if(ch[idx2]!='A' && ch[idx1]=='A') { // 왼쪽이 A가 아닐 때
					// 왼쪽 이동. 문자 변경
					
					min+=Math.min(ch.length-idx2+x, Math.abs(idx2-x));
					min+=Math.min(ch[idx2]-'A', 'Z'+1-ch[idx2]);
					
					cnt--;
					y=1;
					x = idx2;
					ch[idx2] = 'A';
				}else if(ch[idx2]=='A' && ch[idx1]!='A') { // 오른쪽이 A가 아닐 때
					// 오른쪽 이동. 문자 변경
					min+=Math.abs(idx1-x);
					min+=Math.min(ch[idx1]-'A', 'Z'+1-ch[idx1]);

					cnt--;
					y=1;
					x = idx1;
					ch[idx1] = 'A';
				}else {
					// 모두 A일 경우. 인덱스 넓혀 확인
					y++;
				}
			}
		}
		System.out.println(min);
		
	}

}
