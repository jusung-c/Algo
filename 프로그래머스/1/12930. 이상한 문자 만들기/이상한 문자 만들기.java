class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        int index = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == ' ') {
                index = 0;
                sb.append(c);
                continue;
            }
            
            sb.append(index % 2 == 0 ? 
                      Character.toUpperCase(c) : Character.toLowerCase(c));
            index++;
        }
        
        // System.out.println(sb);
        
        return sb.toString();
    }
}