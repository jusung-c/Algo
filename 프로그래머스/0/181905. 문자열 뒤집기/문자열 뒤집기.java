class Solution {
    public String solution(String my_string, int s, int e) {
        String answer = "";
        for (int i=e; i>=s; i--) {
            answer += String.valueOf(my_string.charAt(i));
        }
        
        return my_string.substring(0, s) + answer + my_string.substring(e+1, my_string.length());
    }
}