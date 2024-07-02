import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String my_string) {
        String line = my_string.toLowerCase();
        String[] answer = line.chars()
            .mapToObj(c -> String.valueOf((char)c))
            .toArray(String[]::new);
        
        Arrays.sort(answer);
        
        return IntStream.range(0, answer.length)
            .mapToObj(i -> answer[i])
            .collect(Collectors.joining());
    }
}