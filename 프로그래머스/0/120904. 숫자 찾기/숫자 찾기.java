import java.util.stream.*;

class Solution {
    public int solution(int num, int k) {
        String answer = "-" + num;
        
        return IntStream.range(0, answer.length())
            .filter(i -> String.valueOf((char)answer.charAt(i)).equals(String.valueOf(k)))
            .map(i -> i)
            .findFirst()
            .orElse(-1);
    }
}