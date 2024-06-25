import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        myStr = myStr.replaceAll("[abc]", "-");
        
        String answer[] = myStr.split("-+");
        
        answer = Arrays.stream(answer)
            .filter(s -> !s.isEmpty())
            .toArray(String[]::new);
        
        return answer.length == 0 ? new String[]{"EMPTY"} : answer;
    }
}