import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String number) {
        int sum = number.chars()
            .map(Character::getNumericValue)
            .sum();
        
        return sum % 9;
    }
}