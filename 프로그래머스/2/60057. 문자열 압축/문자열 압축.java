import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        // 1~문자열의 길이까지 압축 단위 설정해 반복
        for(int unit=1; unit<=s.length(); unit++) {
            
            // 문자열을 압축 단위로 쪼개서 토큰 배열 생성
            List<String> tokens = split(s, unit);
            
            // 토큰 배열을 돌면서 문자열 압축
            String compressed = compress(tokens);
            
            // 압축한 문자열의 길이 최소값 갱신 
            answer = answer > compressed.length() ?
                compressed.length() : answer;
        }
        
        return answer;
    }
    
    public List<String> split(String s, int unit) {
        List<String> tokens = new ArrayList<>();
        
        for (int i=0; i<s.length(); i+=unit) {
            // 남은 원소의 개수가 unit보다 작은 경우
            if (i + unit >= s.length())
                tokens.add(s.substring(i));
            else
                // unit만큼 잘라서 토큰으로 추가
                tokens.add(s.substring(i, i+unit));
        }
        
        return tokens;
    }
    
    public String compress(List<String> tokens) {
        StringBuilder sb = new StringBuilder();
        
        String last = "";
        int cnt = 0;
        
        for (String token : tokens) {
            // 카운팅
            if (token.equals(last)) {
                cnt++;
            } else {
                // 이전 토큰 정보 압축
                if (cnt > 1) sb.append(cnt);
                sb.append(last);
                
                // 새로운 토큰 기준으로 다시 카운팅 시작
                last = token;
                cnt = 1;
            }
        }
        
        // 남은 마지막 토큰 처리
        if (cnt > 1) sb.append(cnt);
            sb.append(last);
        
        return sb.toString();
    }
}