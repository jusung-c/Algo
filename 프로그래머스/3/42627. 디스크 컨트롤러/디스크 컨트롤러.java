import java.util.*;

class Solution {
    public class Task {
        int reqTime;
        int cost;
        
        Task (int reqTime, int cost) {
            this.reqTime = reqTime;
            this.cost = cost;
        }
    }
    
    public int solution(int[][] jobs) {
        // 1. task를 요청순 대기큐에 넣는다.
        PriorityQueue<Task> waitQ = new PriorityQueue<>((t1, t2) -> t1.reqTime - t2.reqTime);
        for (int i=0; i<jobs.length; i++) waitQ.add(new Task(jobs[i][0], jobs[i][1]));
        
        // 2. 요청 시간대로 task를 비용순 작업큐에 넣는다.
        PriorityQueue<Task> workQ = new PriorityQueue<>((t1, t2) -> {
            if (t1.cost != t2.cost) return t1.cost - t2.cost;
            return t1.reqTime - t2.reqTime;
        });
        
        int time = 0;
        int sum = 0;
        
        // 1초씩 경과하면서 해당하는 작업 수행
        while (!waitQ.isEmpty() || !workQ.isEmpty()) {
            // 현재 시각보다 이전에 들어온 요청들을 작업큐에 넣기
            while (!waitQ.isEmpty() && waitQ.peek().reqTime <= time) {
                workQ.add(waitQ.poll());
            }
            
            // 작업큐에 처리할 작업이 있는 경우
            if (!workQ.isEmpty()) {
                // 꺼내서 처리
                Task workT = workQ.poll();
                
                // 시간 갱신
                time += workT.cost;
                
                // 요청 시간으로부터 최종 완료까지 걸린 시간 더해주기
                sum += (time - workT.reqTime); 
            } else {
                // 작업큐에 처리할 작업이 없으면 대기큐의 다음 작업의 요청 시간으로 이동
                time = waitQ.peek().reqTime;
            }
            
        }
        
        // System.out.println(sum);
        // System.out.println(jobs.length);
        
        return sum / jobs.length;
    }
}