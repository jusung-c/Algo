class Solution {
    public String solution(String s) {
        
        StringBuilder sb = new StringBuilder();
        boolean isUpper = true; // 다음 이어붙일 알파벳 대소문자 결정
        
        // 문자열의 모든 문자에 대해 반복
        for (char c : s.toCharArray()) {
            // 공백일 경우
            if (c == ' ') {
                // 그대로 이어 붙이기
                sb.append(c);
                
                // 공백의 다음은 0번째 인덱스로 대문자 처리
                isUpper = true;   
            
            // 공백이 아닐 경우    
            } else {
                // isUpper에 따라 대소문자 변환
                sb.append(isUpper ? Character.toUpperCase(c) : Character.toLowerCase(c));
                
                // 다음을 위해 반전
                isUpper = !isUpper;
            }
        }
        
        
        
        return sb.toString();
    }
}