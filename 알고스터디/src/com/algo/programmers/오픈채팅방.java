package com.algo.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 오픈채팅방 {
	
	public static void main(String[] args) {
		
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[] ans = Solution(record);
		
	}

	private static String[] Solution(String[] record) {
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        
        for(String str : record){
            StringTokenizer st = new StringTokenizer(str);
            String command = st.nextToken();
            String userId = st.nextToken();
            String userName = "";
            
            if(!command.equals("Leave")){
                userName = st.nextToken();
            }
            
            switch(command){
                case "Enter":
                    map.put(userId, userName);
                    list.add(userId + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    list.add(userId + "님이 나갔습니다.");
                    break;
                case "Change":
                    map.put(userId, userName);
                    break;
            }
        }   
        String[] answer = new String[list.size()];
        int idx = 0;    
        for(String str : list){
            int endIdx = str.indexOf("님");
            String userId = str.substring(0, endIdx);      
            answer[idx++] = str.replace(userId, map.get(userId));
        }
        return answer;
	}
}
