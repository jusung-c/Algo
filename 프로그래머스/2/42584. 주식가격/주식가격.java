import java.util.*;

class Solution {
    class Info {
        int time;   // 들어간 시간
        int price;  // 들어간 가격
        Info(int time, int price) {
            this.time = time;
            this.price = price;
        }
    }
    public int[] solution(int[] prices) {
        Deque<Info> que = new ArrayDeque<>();
        int[] result = new int[prices.length];
        
        for (int i=0; i<prices.length; i++) {
            // 가격이 떨어진 경우
            while (!que.isEmpty() && que.peekLast().price > prices[i]) {
                // 큐에서 빼주기
                int time = que.pollLast().time;
                // 버틴 시간 갱신
                result[time] = i - time;
            }
            
            // 큐가 비어있거나, 가격이 떨어지지 않았으면 현재 주식 정보 넣기
            que.add(new Info(i, prices[i]));
        }
        
        for (Info i : que) {
            result[i.time] = prices.length - i.time - 1;
        }
        
        return result;
    }
}