class Solution {
    public String solution(String s, int n) {
        
        // 연산이 끝난 문자들을 이어붙이기 위한 StringBuilder
        StringBuilder sb = new StringBuilder();
        
        // 문자들을 하나씩 암호화한다.
        for (char c : s.toCharArray()) {
            // 암호화한 문자를 이어 붙이기
            sb.append(encryt(c, n));
        }
        
        return sb.toString();
    }
    
    public char encryt(char c, int n) {
        // 공백의 경우는 그대로 공백
        if (!Character.isAlphabetic(c)) return c;
        
        // 0을 기준으로 맞춰주기 (대소문자 구별)
        int offset = Character.isUpperCase(c) ? 'A' : 'a';
        int position = c - offset;
        
        // n만큼 더해준 후 나머지 연산으로 인덱스 구하기
        position = (position + n) % 26;
        
        // 인덱스에 offset 더해줘서 실제 문자 반환
        return (char) (position + offset);
    }
}