import java.util.*;

class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int denom = denom1 * denom2;
        int numer = numer1 * denom2 + numer2 * denom1;
        int min = Math.min(numer, denom);
        
        // System.out.println("분자: " + numer + " 분모: " + denom);
        
        for(int i=min; i>0; i--) {
            if (numer % i == 0 && denom % i == 0) {
                denom = denom / i;
                numer = numer / i;
            }
        }
        
        return new int[]{numer, denom};
        
    }
}