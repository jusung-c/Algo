import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        IntStream.range(0, arr.length)
            .filter(i -> intervals[0][0] <= i && i <= intervals[0][1])
            .forEach(i -> answer.add(arr[i]));
        
        IntStream.range(0, arr.length)
            .filter(i -> intervals[1][0] <= i && i <= intervals[1][1])
            .forEach(i -> answer.add(arr[i]));
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}