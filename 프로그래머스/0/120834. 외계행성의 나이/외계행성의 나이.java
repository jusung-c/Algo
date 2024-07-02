import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int age) {
        String answer = "" + age;
        
        return answer.chars()
            .mapToObj(c -> String.valueOf((char)(c+49)))
            .collect(Collectors.joining());
    }
}