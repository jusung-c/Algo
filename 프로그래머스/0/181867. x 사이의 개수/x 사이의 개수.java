import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String myString) {
        String[] list = myString.split("x", -1);
        
        int answer[] = new int[list.length];
        
        IntStream.range(0, list.length)
            .forEach(i -> answer[i] = list[i].length());
        
        return answer;
    }
}