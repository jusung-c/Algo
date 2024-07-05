import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int max = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i : array) {
            int cnt = map.getOrDefault(i, 0) + 1;
            
            if (cnt > max) {
                max = cnt;
                answer = i;
            } else if (cnt == max) {
                max = cnt;
                answer = -1;
            }
            
            map.put(i, cnt);
        }
        
        return answer;
    }
}