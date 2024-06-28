import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        return IntStream.range(0, my_string.length())
            .filter(i -> {
                for (int index : indices) {
                    if (index == i) return false;
                }
                return true;
            })
            .mapToObj(i -> String.valueOf(my_string.charAt(i)))
            .collect(Collectors.joining());
    }
}