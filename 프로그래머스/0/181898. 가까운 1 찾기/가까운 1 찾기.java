import java.util.stream.*;

class Solution {
    public int solution(int[] arr, int idx) {
        return IntStream.range(idx, arr.length)
            .filter(i -> arr[i] == 1)
            .min()
            .orElse(-1);
    }
}