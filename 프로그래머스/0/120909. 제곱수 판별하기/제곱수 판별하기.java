class Solution {
    public int solution(int n) {
        int answer = 1;
        
        while (true) {            
            if (answer * answer >= n) break;
            
            answer++;
        }
        
        System.out.println(answer);
        
        return answer*answer == n ? 1 : 2;
    }
}