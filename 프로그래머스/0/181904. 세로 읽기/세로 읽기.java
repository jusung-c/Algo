import java.util.stream.*;

class Solution {
    public String solution(String my_string, int m, int c) {
        return IntStream.range(0, my_string.length())
            .filter(i -> i % m == 0)
            .filter(i -> i+c-1 < my_string.length())
            .mapToObj(i -> String.valueOf(my_string.charAt(i+c-1)))
            .collect(Collectors.joining());
    }
}