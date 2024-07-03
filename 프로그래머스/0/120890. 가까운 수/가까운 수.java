import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = array.length - 1;
        
        if (array.length == 1) return array[0];
        
        Arrays.sort(array);
        
        for (int i=1; i<array.length; i++) {
            if (array[i] == n) return array[i];
            
            if (array[i] > n) {
                answer = i;
                break;
            }
        }
        
        int a = Math.abs(n - array[answer]);
        int b = Math.abs(n - array[answer-1]);
        
        return a < b ? array[answer] : array[answer-1];
        
    }
}