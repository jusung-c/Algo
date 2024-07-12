import java.util.stream.*;

class Solution {
    public int[] solution(long n) {
        // 1. 정수 -> 문자열
        String str = String.valueOf(n);
        
        // 2. 문자열 뒤집기
        String reversed = new StringBuilder(str).reverse().toString();
        
        // 3. 뒤집힌 문자열을 배열로 변환
        char[] arr = reversed.toCharArray();
        
        // 4. 배열의 각 문자를 정수로 변환
        int[] answer = IntStream.range(0, arr.length)
            .map(i -> arr[i] - '0')
            .toArray();
        
        return answer;
    }
}