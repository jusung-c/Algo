import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (String str : intStrs) {
            int cand = Integer.parseInt(IntStream.range(s, s+l)
                .mapToObj(i -> String.valueOf(str.charAt(i)))
                .collect(Collectors.joining()));
            
            if (cand > k) answer.add(cand);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}