import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 기능의 개발 속도는 다르다.
        // 앞 기능이 먼저 배포되어야 뒤 기능이 배포될 수 있다.
        
        // 작업: 93, 30, 55
        
        ArrayList<Integer> need = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        
        // 1. 각 작업의 완료까지의 일수를 계산한다.
        // 완료 일수: 7, 3, 9
        
       
        for (int i=0; i<progresses.length; i++) {
            int todo = 100 - progresses[i];
            int needDay = todo % speeds[i] > 0 ? 
                (todo/speeds[i])+1 : todo/speeds[i];
            
            need.add(needDay);
        }
        
        
        // 2. 각 배포마다 몇 개의 기능이 배포되는지 계산한다.
        // 배포: 7일차 2개, 9일차 1개
        int prevDay = need.get(0);
        int cnt = 1;
        for (int i=1; i<need.size(); i++) {
            if (need.get(i) > prevDay) {
                answer.add(cnt);
                cnt = 1;
                prevDay = need.get(i);
            } else {
                cnt++;
            }
        }
        
        answer.add(cnt);
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}