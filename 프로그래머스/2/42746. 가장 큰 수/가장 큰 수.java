import java.util.stream.*;
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        return Arrays.stream(numbers)            // IntStream
            .mapToObj(String::valueOf)                             // Stream<String>
            .sorted((s1, s2) -> {
                // 두 숫자를 순서대로, 역순으로 이어붙인 뒤 비교
                int original = Integer.parseInt(s1 + s2);
                int reversed = Integer.parseInt(s2 + s1);
                
                return reversed - original;
            })                                   // Stream<String>
            .collect(Collectors.joining(""))     // String
            .replaceAll("^0+", "0");             // String
            
    }
}