import java.util.*;

class Solution {
    static class Task {
        int num, order;
        Task(int num, int order) {
            this.num = num;
            this.order = order;
        }
    }
    
    public boolean checkOrder(Task pt, Deque<Task> que) {
        for (Task t : que) {
            if (pt.order < t.order) return false;
        }
        
        return true;
    }
    
    public int solution(int[] priorities, int location) {
        Deque<Task> que = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int answer = 0;
        
        // 1. 작업을 큐와 순서도에 넣기
        for (int i=0; i<priorities.length; i++) {
            Task t = new Task(i, priorities[i]);
            que.addLast(t);
            pq.add(priorities[i]);
        }
        
        // 2. 큐에서 작업을 하나씩 꺼내면서 조건 확인
        while(!que.isEmpty()) {
            Task t = que.poll();
            
            if (t.order == pq.peek()) {
                answer++;
                pq.poll();
                
                if (location == t.num) return answer;
            }
            else que.addLast(t);
        }
        
        return -1;
    }
}