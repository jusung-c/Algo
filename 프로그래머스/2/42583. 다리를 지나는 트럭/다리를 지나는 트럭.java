import java.util.*;

class Solution {
    static class Truck {
        int weight, rDist;
        Truck(int weight, int rDist) {
            this.weight = weight;
            this.rDist = rDist;
        }
        
        void oneSecAfter() {
            this.rDist--;
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck) {
        
        Deque<Truck> bridge = new ArrayDeque<>();
        int time = 0;
        int curWeight = 0;
        
        for (int truckWeight : truck) {
            
            // 다음 트럭 올라탈 수 있는 무게가 될 때까지 시간 보내기
            while (curWeight + truckWeight > weight) {
                for (Truck t : bridge) {
                    t.oneSecAfter();
                    
                    // 다리의 끝에 도달한 경우
                    if (t.rDist == 0) {
                        curWeight -= t.weight;
                        bridge.removeFirst();
                    }
                }
                time++;
            }
                        
            // 트럭을 새로 진입시키고 1초 경과 시키기
            bridge.addLast(new Truck(truckWeight, bridge_length));
            for (Truck t : bridge) {
                t.oneSecAfter();
                    
                // 다리의 끝에 도달한 경우
                if (t.rDist == 0) {
                    curWeight -= t.weight;
                    bridge.removeFirst();
                }
            }
            
            curWeight += truckWeight;
            time++;
        }
        
        time += bridge.removeLast().rDist + 1;
        return time;
    }
}