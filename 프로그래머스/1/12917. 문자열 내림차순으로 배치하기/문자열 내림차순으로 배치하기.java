import java.util.stream.*;

class Solution {
    public String solution(String s) {
        return s.chars()
            .mapToObj(c -> (char) c)
            .sorted((v1, v2) -> v2 - v1)
            .map(String::valueOf)
            .collect(Collectors.joining());
    }
}