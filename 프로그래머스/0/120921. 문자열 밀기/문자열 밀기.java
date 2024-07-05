class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        
        if (A.equals(B)) return 0;
        
        for(int i=1; i<A.length(); i++) {
            String s = A.substring(A.length()-i) + A.substring(0, A.length()-i);
            
            if (B.contains(s))
                return i;
        }
        
        return -1;
    }
}