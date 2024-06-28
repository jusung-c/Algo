import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String my_string, int n) {
        return IntStream.range(0, n)
            .mapToObj(index -> String.valueOf(my_string.charAt(index)))
            .collect(Collectors.joining());
    }
}