class Solution {
    public int solution(String my_string) {
        my_string = my_string.replaceAll("[A-Z|a-z]", "");

        int sum = 0;
        for (int i = 0; i < my_string.length(); i++) {
            sum += my_string.charAt(i) - '0';
        }
        
        return sum;
    }
}