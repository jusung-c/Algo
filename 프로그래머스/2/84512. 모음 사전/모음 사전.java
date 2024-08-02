import java.util.ArrayList;
import java.util.List;

class Solution {
    // 1. 상태 정의
    // 단어를 하나씩 이어 붙여서 만들어가야 하므로 현재까지 만든 단어를 word라고 할 때 (word)로 상태를 정의한다.
    private void generator(String word, List<String> words) {
        words.add(word);

        // 2. 종료 조건 정의
        // 5글자의 단어가 완성되면 더 이상 붙일 수 없으므로 종료한다.
        if (word.length() == 5) return;
        
        // 3. 점화식
        // A, E, I, O, U 순으로 단어를 붙여나간다.
        generator(word + "A", words);
        generator(word + "E", words);
        generator(word + "I", words);
        generator(word + "O", words);
        generator(word + "U", words);
    }

    public int solution(String word) {
        List<String> words = new ArrayList<>();
        generator("", words);

        return words.indexOf(word);
    }
}