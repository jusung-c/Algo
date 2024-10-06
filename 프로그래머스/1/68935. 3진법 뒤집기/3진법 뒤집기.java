class Solution {
    public int solution(int n) {
        
        // 1. 3진법으로 변환
        String s = Integer.toString(n, 3);
        
        // 2. 뒤집기
        s = new StringBuilder(s).reverse().toString();
        
        // 3. 10진법으로 변환
        return Integer.parseInt(s, 3);
        
    }
}