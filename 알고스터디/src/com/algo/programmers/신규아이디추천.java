package com.algo.programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 신규아이디추천 {

	public static void main(String[] args) {

		solution("...!@BaT#*..y.abcdefghijklm");
		solution("z-+.^.");
		solution("=.=");
		solution("123_.def");
		solution("abcdefghijklmn.p");
	}

	static public String solution(String new_id) {

		// 대문자를 소문자로
		new_id = new_id.toLowerCase();

		List<Character> list = new ArrayList<>();
		
		char[] ch = new_id.toCharArray();

		for (int i = 0; i < ch.length; i++) {

			list.add(ch[i]);
		}

		// 제외한 모든 문자 제거.

		int k = 0;
		while (true) {
			if (k == list.size())
				break;
			if (!(Character.isDigit(list.get(k)) || Character.isLowerCase(list.get(k)) || list.get(k) == '-'
					|| list.get(k) == '_' || list.get(k) == '.')) {
				list.remove(k);
				continue;
			}
			k++;
		}

		// 연속 마침표 제거

		k = 0;
		while (true) {

			if (k + 1 == list.size())
				break;
			if (list.get(k) == '.' && list.get(k + 1) == '.') {
				list.remove(k);
				continue;
			}
			k++;

		}
		// 처음 마지막 '.' 이면 제거
		while(!list.isEmpty() && list.get(0) == '.')
		{
			list.remove(0);
		}		
		while(!list.isEmpty() && list.get(list.size() - 1) == '.')
		{
			list.remove(list.size() - 1);
		}
		// 빈 문자열이면 'a' 대입
		while (list.isEmpty()) {
			if(list.size()==3) {
				break;
			}
			if (list.size() == 0) {
				list.add('a');
			}
		}
		// 16 자 이상이면 자르기
		while(list.size()>=16) {		
			list.remove(list.size()-1);
			if(list.get(list.size()-1)=='.') {
				list.remove(list.size()-1);
				
			}
		}
		// 2 자리 이하
		while(list.size()<=2) {
			list.add(list.get(list.size()-1));
		}

		char[] chch = new char[list.size()];

		for (int q = 0; q < list.size(); q++) {
			chch[q] = (char) list.get(q);

		}

		String aaa = new String(chch);

		System.out.println("마지막인디.... :" + aaa);

		String answer = aaa;

		return answer;
	}

}
