import java.util.stream.*;

class Solution {
    public int[] solution(int n) {
        return IntStream.rangeClosed(0, n)
            .filter(i -> i % 2 == 1)
            .toArray();
    }
}