// 참여자 배열 participant, 완료자 배열 completion
// 완료하지 못한 단 한명의 선수를 찾아라

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String s : participant) 
            map.put(s, map.getOrDefault(s, 0) + 1);
        
        for (String s : completion) {
            map.put(s, map.get(s) - 1);
            if (map.get(s) == 0) map.remove(s);
        }
        
        String answer = "";
        for (String s : map.keySet())
            answer = s;
        
        return answer;
    }
}