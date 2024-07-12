class Solution {
    public String solution(String s, int n) {

        StringBuilder builder = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            // c를 n만큼 밀어서 builder에 붙이기
            builder.append(push(c, n));
        }
        
        return builder.toString();
    }
    
    public char push(char c, int n) {
        if (c == ' ') return c;
        
        int offset = Character.isUpperCase(c) ? 'A' : 'a';
        int position = c - offset;  // 0~25의 수로 표현 
        
        // 26개의 알파벳이므로 나머지 연산으로 위치 찾기
        position = (position + n) % ('z' - 'a' + 1);
        
        // offset과 찾은 위치를 더해 최종 위치 찾기
        return (char) (offset + position);
    }
}