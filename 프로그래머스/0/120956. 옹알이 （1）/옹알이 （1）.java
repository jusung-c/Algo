class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (String s : babbling) {
            s = s.replaceFirst("aya", " ");
            s = s.replaceFirst("ye", " ");
            s = s.replaceFirst("woo", " ");
            s = s.replaceFirst("ma", " ");
            
            System.out.println(s);
            
            s = s.replaceAll("[ ]+", "");
            
            System.out.println(s);
            
            if (s.isEmpty()) {
                answer++;
            }
        }
        
        return answer;
    }
}