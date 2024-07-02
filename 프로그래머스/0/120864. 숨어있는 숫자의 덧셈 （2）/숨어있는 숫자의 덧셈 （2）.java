import java.util.*;

class Solution {
    public int solution(String my_string) {
        String answer = my_string.replaceAll("[a-zA-Z]", " ");
        
        return Arrays.stream(answer.split("[ ]+"))
            .filter(s -> !s.isEmpty())
            .mapToInt(s -> Integer.parseInt(s))
            .sum();
    }
}