class Solution {
    public String solution(String n_str) {
        String answer = "";
        int index = -1;
        
        for (int i=0; i<n_str.length(); i++) {
            char c = n_str.charAt(i);
            
            if (c != '0') break;
            else index = i;
        }

        if (index == -1) return n_str;
        
        for(int i = index + 1; i<n_str.length(); i++) {
            answer += n_str.charAt(i);
        }
        
        return answer;
    }
}