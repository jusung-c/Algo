import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String my_str, int n) {
        ArrayList<String> answer = new ArrayList<>();
        
        for (int i=0; i<my_str.length(); i+=n) {
            if (i+n >= my_str.length()) {
                answer.add(my_str.substring(i));
                break;
            }
            
            answer.add(my_str.substring(i, i+n));
        }
        
        return answer.stream().toArray(String[]::new);
    }
}