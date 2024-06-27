import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String number) {
        int sum = number.chars()
            .map(i -> i - '0')
            .sum();
        
        return sum % 9;
    }
}