class Solution {
    public String solution(String n_str) {
        int index = -1;
        
        for (int i=0; i<n_str.length(); i++) {
            char c = n_str.charAt(i);
            
            if (c != '0') {
                index = i;
                break;
            }
        }

        return n_str.substring(index);
    }
}