import java.util.stream.*;
import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int arr2[] = new int[arr.length];
        int cnt = 0;
        
        while (true) {
            int[] finalArr = arr;
            
            IntStream.range(0, arr.length)
                .forEach(i -> {
                    if (finalArr[i] >= 50 && finalArr[i] % 2 == 0)
                        arr2[i] = finalArr[i] / 2;
                    else if (finalArr[i] < 50 && finalArr[i] % 2 == 1)
                        arr2[i] = finalArr[i] * 2 + 1;
                    else
                        arr2[i] = finalArr[i];
                });
            
            if (EqCheck(arr, arr2))
                return cnt;
            
            arr = Arrays.copyOf(arr2, arr.length);
            cnt++;
        }
        
    }
    
    public boolean EqCheck(int[] arr, int[] arr2) {
        if (arr.length != arr2.length) return false;
        
        for (int i=0; i<arr.length; i++) {
            if (arr[i] != arr2[i]) return false;
        }
        
        return true;
    }
}