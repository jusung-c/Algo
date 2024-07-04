import java.util.*;

class Solution {
    public int solution(int[] sides) {
        int sum = 0;
        
        Arrays.sort(sides); // 7, 11
        
        // sides[1]이 가장 긴 변인 경우
        sum += sides[0]; // 5 ~ 11 -> 7개
        
        // 나머지 하나가 가장 긴 변인 경우
        sum += (sides[0] + sides[1] - 1) - sides[1] + 1 - 1; // 17 ~ 12
        
        return sum;
    }
}