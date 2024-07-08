class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (String s : babbling) {
            s = s.replaceAll("aya", " ");
            s = s.replaceAll("ye", " ");
            s = s.replaceAll("woo", " ");
            s = s.replaceAll("ma", " ");
            s = s.replaceAll("[ ]+", "");
            
            System.out.println(s);
            
            if (s.isEmpty()) {
                answer++;
            }
        }
        
        return answer;
    }
}