import java.util.stream.*;
import java.util.regex.*;

class Solution {
    public int[] solution(int l, int r) {
        
        String pattern = "^[50]*$";

        int[] answer = IntStream.rangeClosed(l, r)
            .filter(i -> i % 5 == 0)
            .filter(i -> Pattern.matches(pattern, String.valueOf(i)))
            .toArray();
        
        return answer.length == 0 ? new int[]{-1} : answer;
    }
}