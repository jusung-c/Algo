import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String myString, String pat) {
        
        int index = 0;
        String s = pat.chars().mapToObj(i -> "-").collect(Collectors.joining());
        
        String answer = myString.replaceAll(pat, s);
        
        for(int i = answer.length() - 1; i>=0; i--) {
            if ((char)answer.charAt(i) == '-') {
                index = i;
                break;
            }
        }
                
        return myString.substring(0, index+1);
    }
}