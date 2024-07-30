import java.util.stream.IntStream;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isUpper = true;
        
        // 문자열의 모든 문자에 대해 반복해서 변환을 시도한 후 이어 붙인다.
        for (char c : s.toCharArray()) {
            // 공백일 경우
            if (c == ' ') {
                // 그대로 이어붙이기
                sb.append(c);
                
                // 공백의 다음은 무조건 대문자
                isUpper = true;
            }
            
            // 공백이 아닐 경우
            else {
                // isUpper에 따라 변환
                sb.append(isUpper ? Character.toUpperCase(c) : Character.toLowerCase(c));
                
                // 다음을 위해 반점
                isUpper = !isUpper;
            }
        }

        return sb.toString();
    }
}