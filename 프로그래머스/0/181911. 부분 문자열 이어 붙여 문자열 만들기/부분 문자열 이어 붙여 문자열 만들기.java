import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        String answer = "";
        
        IntStream.range(0, my_strings.length)
            .mapToObj(i -> {
                String str = my_strings[i];
                int[] arr = parts[i];

                return IntStream.range(arr[0], arr[1]+1)
                    .mapToObj(index -> String.valueOf(str.charAt(index)))
                    .collect(Collectors.joining());
            }).collect(Collectors.joining());
        
        for(int i=0; i<my_strings.length; i++) {
            String str = my_strings[i];
            int[] arr = parts[i];
            
            answer += IntStream.range(arr[0], arr[1]+1)
                .mapToObj(index -> String.valueOf(str.charAt(index)))
                .collect(Collectors.joining());
        }
        
        return answer;
    }
}