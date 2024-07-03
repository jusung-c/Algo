import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String s) {
        Map<String, Integer> answer = new HashMap<>();
        
        for(int i=0; i<s.length(); i++) {
            String str = String.valueOf((char)s.charAt(i));
            
            if (!answer.containsKey(str)) {
                answer.put(str, 1);
            } else {
                answer.put(str, answer.get(str)+1);
            }
        }
                
        return answer.entrySet()
            .stream()
            .filter(entry -> entry.getValue() == 1)
            .map(entry -> entry.getKey())
            .sorted()
            .collect(Collectors.joining());
    }
}