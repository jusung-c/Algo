import java.util.stream.*;

class Solution {
    public int solution(int a, int b) {
        int mom = 0;
        
        // 1. 기약분수로 나타내기
        mom = change(a, b);
        
        System.out.println(mom);
        
        // 2. 유한소수 판별하기
        return check(mom) ? 1:2;
    }
    
    public int change(int a, int b) {
        for(int i=a; i>=1; i--) {
            if (b % i == 0 && a % i == 0) {
                b = b/i;
                a = a/i;
            }
        }
        
        return b;
    }
    
    public boolean check(int mom) {
        while (mom > 1) {
            if (mom % 2 == 0) {
                mom = mom / 2;
            } else if (mom % 5 == 0) {
                mom = mom / 5;
            } else {
                return false;
            }
        }
        
        return true;
    }
}