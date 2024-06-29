import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> twos = new ArrayList<>();
        
        IntStream.range(0, arr.length)        
            .filter(i -> arr[i] == 2)
            .forEach(i -> twos.add(i));
        
        if (twos.isEmpty()) return new int[]{-1};

        return Arrays.copyOfRange(arr, twos.get(0), twos.get(twos.size()-1) + 1);
    }
}