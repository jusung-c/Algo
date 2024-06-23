import java.math.BigDecimal;

class Solution {
    public String solution(String a, String b) {
        
        BigDecimal A = new BigDecimal(a);
        BigDecimal B = new BigDecimal(b);
        
        return A.add(B).toString();
    }
}