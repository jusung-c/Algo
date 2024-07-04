class Solution {
    public int solution(int chicken) {
        // 쿠폰 개수
        int cnt = chicken;
        
        // 치킨 수
        int answer = 0;
        
        while (cnt >= 10) {
            answer += cnt / 10;
            cnt = cnt % 10 + cnt / 10;
        }
        
        // 1마리 -> 1개
        // 10마리 -> 10 / 10 = 1, 1마리 + 쿠폰 1개
        // 15마리 -> 15 / 10 = 1, 1마리 + 쿠폰 1개
        // 160마리 -> 쿠폰 160개. 160 / 10 = 16, 10마리 + 쿠폰 10개
        
        return answer;
    }
}