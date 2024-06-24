import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(String s : strArr) {
            map.put(s.length(), 
                    map.containsKey(s.length()) ? map.get(s.length()) + 1 : 1 );
        }
        
        for(Integer key : map.keySet()) {
            answer = Math.max(answer, map.get(key));
        }
        
        return answer;
    }
}