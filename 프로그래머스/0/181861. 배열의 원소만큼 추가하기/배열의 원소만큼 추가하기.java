import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int n : arr) {
            for (int i=0 ; i<n; i++) {
                answer.add(n);
            }
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}