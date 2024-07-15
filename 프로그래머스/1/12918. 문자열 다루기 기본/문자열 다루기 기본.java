class Solution {
    public boolean solution(String s) {
        if (s.length() != 4 && s.length() != 6) return false;
        
        String ns = s.replaceAll("[^0-9]", "");
        
        return s.length() == ns.length();
    }
}