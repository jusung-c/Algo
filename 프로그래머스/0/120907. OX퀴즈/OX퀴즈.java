import java.util.*;

class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for (int i=0; i<quiz.length; i++) {
            String[] token = quiz[i].split(" ");
            
            int x = Integer.parseInt(token[0]);
            int y = Integer.parseInt(token[2]);
            int result = Integer.parseInt(token[4]);
            String op = token[1];
            
            switch (op) {
                case "+":
                    answer[i] = x + y == result ? "O": "X";
                    break;
                case "-":
                    answer[i] = x - y == result ? "O": "X";
                    break;
            }
        }
        
        return answer;
    }
}