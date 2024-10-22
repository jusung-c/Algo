// 이중 우선순위 큐
// 삽입, 최대값 추출, 최솟값 추출 기능

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        // 1. 이중 우선순위 큐 관리
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((i1, i2) -> i2 - i1);
        PriorityQueue<Integer> minQ = new PriorityQueue<>((i1, i2) -> i1 - i2);
        
        // 2. 입력받은 명령어를 순차적으로 처리한다.
        for (int i=0; i<operations.length; i++) {
            String[] req = operations[i].split(" ");
            
            String op = req[0];
            int num = Integer.parseInt(req[1]);
            
            switch (op) {
                case "I":
                    maxQ.add(num);
                    minQ.add(num);
                    break;
                case "D":
                    if (num == 1) {
                        if (maxQ.isEmpty()) {
                            // System.out.println("큐가 비어있으므로 패쓰합니다.");
                            continue;    
                        }
                        
                        int max = maxQ.poll();
                        // System.out.println("차출할 Max값: " + max);
                        minQ.remove(max);
                    } else {
                        if (minQ.isEmpty()) {
                            // System.out.println("큐가 비어있으므로 패쓰합니다.");
                            continue;    
                        }
                        
                        int min = minQ.poll();
                        // System.out.println("차출할 Min값: " + min);
                        maxQ.remove(min);
                    }
                    break;
            }
        }
        
//         System.out.println("max 큐 출력...");
//         for (int i=0; i<maxQ.size(); i++) System.out.print(maxQ.poll() + " \n");
        
//         System.out.println("\nmin 큐 출력...");
//         for (int i=0; i<minQ.size(); i++) System.out.print(minQ.poll() + " \n");
        
        int[] answer = {};
        if (maxQ.isEmpty() && minQ.isEmpty()) 
            answer = new int[] {0, 0};
        else
            answer = new int[] {maxQ.poll(), minQ.poll()};
        
        return answer;
    }
}