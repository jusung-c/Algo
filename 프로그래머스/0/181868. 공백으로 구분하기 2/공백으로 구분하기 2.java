import java.util.stream.*;

class Solution {
    public String[] solution(String my_string) {
        String[] answer = my_string.split(" ");
        
        return IntStream.range(0, answer.length)
            .filter(i -> !answer[i].isEmpty())
            .mapToObj(i -> answer[i])
            .toArray(String[]::new);
    }
}