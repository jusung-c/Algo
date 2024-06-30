import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String myString) {
        return myString.chars()
            .mapToObj(i -> {
                if (i == 'a' || i == 'A') return "A";
                else if (i == ' ') return " ";
                else return String.valueOf((char)i).toLowerCase();
            })
            .collect(Collectors.joining());
    }
}