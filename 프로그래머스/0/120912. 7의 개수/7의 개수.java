class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        for(int n : array) {
            answer += countSeven(n);
        }
        
        return answer;
    }
    
    public int countSeven(int n) {
        String s = "" + n;
        
        return (int) s.chars()
            .filter(c -> c == '7')
            .count();
    }
}