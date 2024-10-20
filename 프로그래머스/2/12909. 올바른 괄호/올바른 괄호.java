import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        // 1. 문자 배열로 변환
        char[] chars = s.toCharArray();
        
        // 2. "("이면 스택에 넣고 ")"를 발견하면 스택에서 "(" 하나를 꺼낸다.
        // 이 때 꺼낼 게 없거나, 모든 작업 후 스택이 비어있지 않다면 올바르지 않은 괄호인 것
        Deque<Character> que = new ArrayDeque<>();
        for (int i=0; i<chars.length; i++) {
            if (chars[i] == '(') {
                // System.out.println("'('를 추가합니다.");
                que.addLast('(');
            } else {
                if (que.isEmpty()) {
                    // System.out.println("더 이상 뺄 '('가 없어요.");
                    return false;
                }
                // System.out.println("'('를 제거합니다.");
                que.removeLast();
            }
        }
        
        return que.isEmpty() ? true : false;
    }
}