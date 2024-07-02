import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int[] solution(String my_string) {
        String answer = my_string.replaceAll("[a-z]", "");
        
        return answer.chars()
            .map(i -> Integer.parseInt(String.valueOf((char)i)))
            .sorted()
            .toArray();
    }
}

// 숫자 0~9 아스키 코드 값: 48 ~ 57 