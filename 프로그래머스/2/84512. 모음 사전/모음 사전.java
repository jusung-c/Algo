import java.util.*;

class Solution {
    static String[] words = new String[] {"A", "E", "I", "O", "U"};
    static ArrayList<String> dict = new ArrayList<>();
    static String answer;
    
    public void makeDict(StringBuilder maked) {
        dict.add(maked.toString());
        
        // 5자리 다 채워졌으면 추가하고 탈출
        if (maked.length() == 5) return;
        
        // 현재 단어에서 추가로 A, E, I, O, U 하나씩 붙여서 단어 만들기
        for (String s : words) {
            maked.append(s);
            makeDict(maked);
            maked.deleteCharAt(maked.length() - 1);
        }
    }
    
    public int solution(String word) {
        // 'A', 'E', 'I', 'O', 'U' 만을 사용한 길이 5 이하의 단어
        // 사전 순서: "A" "AA" ... "AAAAA" "AAAAE" ... "AAAAU" "AAAE" ... "UUUUU"
        
        // 5개 문자 중 5개를 중복있이 순서있지 나열하는 경우다.
        // 기껏해야 5*5*5*5*5니까 모든 경우의 수를 다 탐색해도 된다.
        
        // 1. 사전 완성하기
        makeDict(new StringBuilder());
        
        // 2. 해당하는 단어 인덱스 반환
        return dict.indexOf(word);
    }
}