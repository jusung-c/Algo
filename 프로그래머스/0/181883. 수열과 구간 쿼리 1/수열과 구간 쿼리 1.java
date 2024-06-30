import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        IntStream.range(0, queries.length)
            .forEach(q -> IntStream.rangeClosed(queries[q][0], queries[q][1])
                .forEach(i -> arr[i] += 1));
        
        return arr;
    }
}