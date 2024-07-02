class Solution {
    public int solution(int n) {
        // 6의 배수 중 n으로 나누어 떨어지는 최소 n
        // -> 최소공배수
        
        int answer = 6;
    
        while (true) {
            if (answer % n == 0)
                return answer / 6;
            
            answer += 6;
        }
    }
}