class Solution {
    public String solution(String my_string, int s, int e) {
        String front = "";
        String mid = "";
        String end = "";
        
        for (int i=0; i<my_string.length(); i++) {
            if (i < s) {
                front += String.valueOf(my_string.charAt(i));
            } else if (i > e) {
                end += String.valueOf(my_string.charAt(i));
            }
        }
        
        for (int i=e; i>=s; i--) {
            mid += String.valueOf(my_string.charAt(i));
        }

        System.out.println(front);
        System.out.println(mid);
        System.out.println(end);
        
        return front + mid + end;
    }
}