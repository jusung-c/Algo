import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        // 매일 다른 옷을 조합하여 입는다.
        
        
        // 종류별 의상 개수를 map에 저장한다.
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        int answer = 1;
        
        // 의상은 종류별로 최대 1개 선택 가능하다.
        for (String s : map.keySet()) {
            answer *= map.get(s) + 1;
        }
        
        System.out.println("answer = " + answer);
        
        // 전부 안 고르는 하나의 경우 빼주기
        return answer - 1;
    }
}