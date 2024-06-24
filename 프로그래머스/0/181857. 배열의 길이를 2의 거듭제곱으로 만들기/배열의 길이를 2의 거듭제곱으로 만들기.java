import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int n = 0;
        
        for (int i=0; i<11; i++) {
            int k = (int) Math.pow(2, i);
            if (k == arr.length) return arr;
            
            if (k > arr.length) {
                n = (int) Math.pow(2, i);
                break;
            }
        }
        
        int answer[] = new int[n];
        
        for(int i=0; i<arr.length; i++) {
            answer[i] = arr[i];
        }
        
        return answer;
    }
}