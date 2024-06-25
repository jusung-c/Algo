import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        myStr = myStr.replaceAll("[abc]", "-");
        
        String answer[] = myStr.split("-+");
        
        answer = Arrays.stream(answer)
            .filter(s -> !s.isEmpty())
            .toArray(String[]::new);
        
        if (answer.length == 0) return new String[]{"EMPTY"};
        
        return answer;
    }
}