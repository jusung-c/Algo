class Solution {
    static String[] alphabet = new String[] {
        "zero", "one", "two", "three", "four", "five",
        "six", "seven", "eight", "nine"
    };
    
    public int solution(String s) {
        
        for (int i=0; i<alphabet.length; i++) {
            if (s.contains(alphabet[i]))
                s = s.replaceAll(alphabet[i], String.valueOf(i));
        }
        
        return Integer.parseInt(s);
    }
}