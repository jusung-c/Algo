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
        ArrayList<Task> orders = new ArrayList<>();
        
        // 1. 작업을 큐와 순서도에 넣기
        for (int i=0; i<priorities.length; i++) {
            Task t = new Task(i, priorities[i]);
            que.addLast(t);
        }
        
        // 2. 큐에서 작업을 하나씩 꺼내면서 조건 확인
        while(!que.isEmpty()) {
            Task t = que.poll();
            
            if (checkOrder(t, que)) orders.add(t);
            else que.addLast(t);
        }
        
        int answer = -1;
        
        for (int i=0; i<orders.size(); i++) {
            if(orders.get(i).num == location) {
                answer = i;
                break;
            }
        }
        
        return answer + 1;
    }
}