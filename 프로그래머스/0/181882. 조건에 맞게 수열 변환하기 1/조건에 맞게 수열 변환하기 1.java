import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr) {
        IntStream.range(0, arr.length)
            .forEach(i -> {
                if (arr[i] >= 50 && arr[i] % 2 == 0) 
                    arr[i] /= 2;
                else if (arr[i] < 50 && arr[i] % 2 == 1) {
                    arr[i] *= 2;
                }
            });
        
        return arr;
            
    }
}