import java.util.*;
import java.util.stream.*;

class Solution {
    
    public int solution(int[] citations) {
        // 역순 정렬
        Integer[] arr = Arrays.stream(citations)
            .boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());
        citations = Arrays.stream(arr)
            .mapToInt(Integer::intValue).toArray();
        
        for (int i=0; i<citations.length; i++) {
            if (citations[i] < i+1) return i;
        }
        
        return citations.length;
    }
}