import java.util.*;

class Solution {
    class Truck {
        int weight; // 트럭의 무게
        int move;   // 트럭의 이동한 거리

        Truck(int weight, int move) {
            this.weight = weight;
            this.move = move;
        }

        void moving() {
            this.move++;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Truck> waitQ = new ArrayDeque<>();    // 트럭 대기열
        Deque<Truck> moveQ = new ArrayDeque<>();    // 다리
        
        // 대기열에 트럭 저장
        for (int i : truck_weights) waitQ.add(new Truck(i, 0));
        
        int curW = 0;   // 현재 다리의 무게
        int time = 0;   // 흘러간 시간
        
        // 대기열과 다리 위의 트럭이 존재하지 않을 때까지 반복
        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
            
            // 매 반복마다 1초 경과
            time++;
            
            // 다리에 트럭이 없는 경우
            if (moveQ.isEmpty()) {
                // 대기열의 트럭이 다리에 진입한다.
                Truck t = waitQ.poll();
                moveQ.add(t);
                curW += t.weight;
                continue;
            }
            
            // 다리 위의 트럭들 1초간 이동
            for (Truck t : moveQ) t.moving();
            
            // 도착한 트럭이 있는 경우 제외
            if (moveQ.peek().move == bridge_length) {
                Truck t = moveQ.poll();
                curW -= t.weight;
            }
            
            // 다 이동시킨 뒤에 새로운 트럭 올릴 수 있으면 올리기
            if (!waitQ.isEmpty() && curW + waitQ.peek().weight <= weight) {
                // 대기열의 트럭이 다리에 진입한다.
                Truck t = waitQ.poll();
                moveQ.add(t);
                curW += t.weight;
            }
        }
        
        return time;
    }
}