import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public String solution(String s) {
        String answer = "";

        return IntStream.range(0, s.length())          // IntStream
                .mapToObj(i -> s.charAt(i))     // Stream<Character>
                .sorted((v1, v2) -> v2 - v1)    // Stream<Character>
                .map(String::valueOf)           // Stream<String>
                .collect(Collectors.joining(""));  // String
    }
}