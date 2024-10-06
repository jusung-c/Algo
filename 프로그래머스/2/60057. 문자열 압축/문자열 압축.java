import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;

        // 1부터 s.length()까지 압축 단위를 지정
        for (int unit=1; unit<=s.length(); unit++) {
            
            // 압축 단위를 기준으로 문자열 토큰화
            List<String> tokens = makeTokenList(s, unit);
            
            // 토큰화된 리스트를 돌면서 문자열 압축
            String pressedString = press(tokens);
            
            answer = Math.min(answer, pressedString.length());
        }

        return answer;
    }

    public List<String> makeTokenList(String s, int unit) {
        List<String> tokenList = new ArrayList<>();
        String token = "";
        
        for (int index=0; index<s.length(); index+=unit) {
            
            if (index+unit > s.length()) token = s.substring(index);
            else token = s.substring(index, index+unit);
            
            tokenList.add(token);
        }
        
        return tokenList;
    }
    
    public String press(List<String> tokens) {
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        String last = tokens.get(0);
        
        for (int i=1; i<tokens.size(); i++) {
            last = tokens.get(i);
            
            if (tokens.get(i-1).equals(last)) {
                cnt++;
            } else {
                if (cnt > 1) sb.append(cnt);
                sb.append(tokens.get(i-1));
                cnt = 1;
            }
        }
        
        if (cnt > 1) sb.append(cnt);
        sb.append(last);
        
        return sb.toString();
    }
}