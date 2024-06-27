class Solution {
    public String solution(String my_string, int[][] queries) {
        for(int i=0; i<queries.length; i++) {
            my_string = reverse(my_string, queries[i][0], queries[i][1]);
        }
        
        return my_string;
    }
    
    private String reverse(String my_string, int s, int e) {
        String str = "";
        
        for (int i=0; i<s; i++) {
            str += my_string.charAt(i);
        }
        
        for (int i=e; i>=s; i--) {
            str += my_string.charAt(i);
        }
        
        for (int i=e+1; i<my_string.length(); i++) {
            str += my_string.charAt(i);
        }
        
        return str;
    }
}