import java.lang.Math.*;

class Solution {
    public int solution(int a, int b) {        
        boolean isA = a % 2 == 1;
        boolean isB = b % 2 == 1;
        
        if (isA && isB) return (int)(Math.pow(a, 2) + Math.pow(b, 2));
        else if (!isA && !isB) return (int)Math.abs(a-b);
        else return 2 * (a + b);
        
    }
}