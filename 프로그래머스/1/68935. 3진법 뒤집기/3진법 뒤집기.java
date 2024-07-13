class Solution {
    public int solution(int n) {
        // 10진법 정수 -> 3진법 문자열
        String s = Integer.toString(n, 3);
        
        // 문자열 뒤집기
        String reversed = new StringBuilder(s).reverse().toString();
        
        // 3진법 문자열 -> 10진법 정수
        return Integer.parseInt(reversed, 3);
    }
}