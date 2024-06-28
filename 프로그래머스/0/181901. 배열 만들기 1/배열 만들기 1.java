import java.util.stream.*;

class Solution {
    public int[] solution(int n, int k) {
        
        return IntStream.range(1, n+1)
            .filter(i -> i %k ==0)
            .toArray();
    }
}