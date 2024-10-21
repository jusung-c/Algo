// 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶다.
// 스코빌 지수가 가장 낮은 2개의 음식을 섞어 새로운 음식으로 만든다.
// 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복해서 섞는다. 

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int cnt = 0;
        
        // 1. 스코빌 지수가 낮은 음식이 앞으로 오도록 우선 순위 큐에 음식을 저장한다.
        PriorityQueue<Integer> pque = new PriorityQueue<>();
        for (int i=0; i<scoville.length; i++) pque.add(scoville[i]);
        
        // 2. 제일 작은 스코빌 지수가 K를 넘는지 확인한다.
        while (K > pque.peek()) {
            
            // 사이즈가 2보다 작으면 모든 스코빌 지수를 K 이상으로 만들 수 없는 것
            if (pque.size() < 2) return -1;
            
            // 새로운 음식 만들어서 큐에 넣기
            int s1 = pque.poll();
            int s2 = pque.poll();
            int newS = (s1 + s2*2);
            cnt++;
            pque.add(newS);
        }

        return cnt;
    }
}