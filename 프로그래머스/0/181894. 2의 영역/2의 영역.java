import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr) {
        int twos[] = IntStream.range(0, arr.length)        
            .filter(i -> arr[i] == 2)
            .toArray();
        
        if (twos.length == 0) return new int[]{-1};

        return Arrays.copyOfRange(arr, twos[0], twos[twos.length-1] + 1);
    }
}