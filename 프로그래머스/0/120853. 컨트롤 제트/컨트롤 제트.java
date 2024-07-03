import java.util.stream.*;

class Solution {
    public int solution(String s) {
        String str[] = s.split(" ");
        
        return IntStream.range(0, str.length)
            .filter(i -> !(str[i].equals("Z") || (i+1 <str.length && str[i+1].equals("Z"))))
            .map(i -> Integer.parseInt(str[i]))
            .sum();
    }
}