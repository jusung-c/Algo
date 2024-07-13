import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        // 압축 단위
        for (int unit=1; unit<=s.length(); unit++) {
            // unit 단위로 토큰 배열 생성
            List<String> tokens = split(s, unit);
            
            // token 배열을 반복해서 문자열 압축
            String compressed = compress(tokens, unit);
            
            // 압축한 문자열 길이 최소값 갱신
            answer = answer > compressed.length() ? compressed.length() : answer;
                
        }
        
        return answer;
    }
    
    public List<String> split(String s, int unit) {
        List<String> tokens = new ArrayList<>();
        
        for(int i=0; i<s.length(); i += unit) {
            // 남은 원소 개수가 unit보다 작은 경우는 남은것만 추가
            if (i + unit > s.length()) 
                tokens.add(s.substring(i));
            else
                // unit 수만큼 잘라서 추가
                tokens.add(s.substring(i, i + unit));          
        }
        
        return tokens;
    }
    
    public String compress(List<String> tokens, int unit) {
        StringBuilder sb = new StringBuilder();
        
        String last = "";
        int count = 0;
        
        // token을 돌면서 개수 세기
        for (String token : tokens) {
            // 이전 토큰과 같을 경우
            if (last.equals(token)) {
                count++;
                
            // 이전 토큰과 다를 경우
            } else {
                if (count > 1) sb.append(count);
                
                sb.append(last);
                
                last = token;
                count = 1;
            }
        }
        
        // 마지막 남은 1개 토큰 처리
        if (count > 1) sb.append(count);
        sb.append(last);
        
        return sb.toString();
    }
}