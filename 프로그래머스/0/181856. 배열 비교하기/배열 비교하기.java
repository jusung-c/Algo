import java.util.*;

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int a = arr1.length;
        int b = arr2.length;
        
        if (a < b) {
            return -1;
        } else if (a > b) {
            return 1;
        }
        
        int sa = Arrays.stream(arr1).sum();
        int sb = Arrays.stream(arr2).sum();
        
        return sa == sb ? 0 : (sa < sb ? -1 : 1);
    }
}