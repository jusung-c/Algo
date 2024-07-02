class Solution {
    public int solution(int order) {
        String answer = "" + order;
        
        return (int) answer.chars()
            .filter(c -> c == '3' || c=='6' || c=='9')
            .count();
    }
}