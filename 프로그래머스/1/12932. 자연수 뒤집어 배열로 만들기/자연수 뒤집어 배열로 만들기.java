import java.util.stream.*;

class Solution {
    public int[] solution(long n) {
        
        // 1. 문자열로 변환한 뒤 순서를 뒤집어서 char 배열로 만들기
        char[] answer = new StringBuilder(Long.toString(n))
                .reverse()
                .toString()
                .toCharArray();
        
        // 2. 배열의 각 문자를 정수로 변환해서 제출
        return IntStream.range(0, answer.length)   // IntStream
            .map(i -> answer[i] - '0')      // IntStream
            .toArray();                     // int[]
    }
}