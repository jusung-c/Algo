import java.util.*;

class Solution {
    private static final char[] CHARS = "AEIOU".toCharArray();
    
    private List<String> generator(String word) {
        List<String> words = new ArrayList<>();
        words.add(word);
        
        // 종료 조건
        if (word.length() == 5) return words;
        
        // 점화식
        for (char c : CHARS) {
            words.addAll(generator(word + c));
        }
        
        return words;
    }
    
    public int solution(String word) {
        return generator("").indexOf(word);
    }
}