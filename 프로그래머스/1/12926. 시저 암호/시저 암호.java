class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i < s.length(); i++) {
            Character c = s.charAt(i);
            sb.append(c == ' ' ? ' ' : change(c, n));
        }
        
        return sb.toString();
    }
    
    public Character change(Character c, int n) {        
        int offset = Character.isLowerCase(c) ? 'a' : 'A';
        
        return (char) ((c - offset + n) % 26 + offset);
        
    }
}