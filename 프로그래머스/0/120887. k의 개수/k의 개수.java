import java.util.stream.*;

class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        char c = Character.forDigit(k, 10);
        
        for (int n=i; n<=j; n++) {
            String s = String.valueOf(n);
            
            answer += (int) IntStream.range(0, s.length())
                .filter(z -> (char) s.charAt(z) == c)
                .count();
        }
        
        return answer;
    }
}