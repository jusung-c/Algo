import java.util.*;


class Solution {
    public int[] solution(int[] arr, int k) {
        int answer[] = new int[k];
        Arrays.fill(answer , -1);
        
        int set[] = Arrays.stream(arr).distinct().toArray();
        
        if (set.length >= k) {
            for(int i=0; i<k; i++) {
                answer[i] = set[i];
            }
        } else {
            for(int i=0; i<set.length; i++) {
                answer[i] = set[i];
            }
        }
        
        return answer;
    }
}