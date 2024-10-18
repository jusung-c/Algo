import java.util.*;

class Solution {
    static String[] alpha = new String[] {"A", "E", "I", "O", "U"};
    static ArrayList<String> dict;
    
    public void makeWord(String prev) {
        // 현재까지 완성한 단어를 사전에 추가
        dict.add(prev);
        
        // 5글자까지 다 완성하면 탈출
        if (prev.length() == 5) return;
        
        // 다음 글자 붙이기
        for (int i=0; i<5; i++) {
            makeWord(prev + alpha[i]);
        }
    }
    
    public int solution(String word) {
        dict = new ArrayList<>();
        
        // 'A', 'E', 'I', 'O', 'U'로 사전 완성하기
        // 사전은 A AA AAA AAAA AAAAA AAAAE ... AAAE AAAEA AAAEE ... UUUUU
        
        // DFS로 하나씩 붙여가면서 만들어보기
        makeWord("");
        
        // for (String s : dict) System.out.println(s);
        
        return dict.indexOf(word);
    }
}