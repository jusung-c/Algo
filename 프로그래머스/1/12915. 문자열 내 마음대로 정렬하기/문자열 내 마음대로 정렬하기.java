import java.util.stream.IntStream;

class Solution {
    public String[] solution(String[] strings, int n) {
        return IntStream.range(0, strings.length)      // IntStream
                .mapToObj(i -> strings[i])      // Stream<String>
                .sorted((s1, s2) -> {
                    if (s1.charAt(n) != s2.charAt(n))
                        return s1.charAt(n) - s2.charAt(n);
                    return s1.compareTo(s2);
                })
                .toArray(String[]::new);
    }
}