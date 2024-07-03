import java.util.*;

class Solution {
    public long solution(String numbers) {
        String answer = "";
        
        Map<String, String> numberMap = Map.of("zero", "0", "one", "1", "two", "2", "three", "3", "four", "4", "five", "5", "six", "6", "seven", "7", "eight", "8", "nine", "9");
        
        String s = "";
        for(int i=0; i<numbers.length(); i++) {
            s += String.valueOf((char)numbers.charAt(i));
            
            if (numberMap.containsKey(s)) {
                answer += numberMap.get(s);
                s = "";
            }
        }
        
        return Long.parseLong(answer);
    }
}