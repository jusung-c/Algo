import java.util.stream.*;
import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        // 2가지 케이스
        // 짝수 - 뒷부분 자르기
        // 홀수 - 앞부분 자르기
        for (int i=0; i<query.length; i++) {
            if (i % 2 == 0) {
                arr = Arrays.copyOfRange(arr, 0, query[i]+1);
            } else {
                arr = Arrays.copyOfRange(arr, query[i], arr.length);
            }
        }
        
        return arr;
    }
}