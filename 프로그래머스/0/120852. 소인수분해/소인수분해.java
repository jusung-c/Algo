import java.util.*;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> answer = new ArrayList<>();
        int num = n;
        
        for(int i=2; i<=n; i++) {
            if (num == 1) break;
            
            if (num % i == 0) {
                answer.add(i);
                num = num / i;
                i--;
            }
        }
        
        return answer.stream()
            .mapToInt(i -> i)
            .distinct()
            .sorted()
            .toArray();
    }
}