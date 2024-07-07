import java.util.*;

class Solution {
    public int[] solution(int num, int total) {
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        
        for(int i=-num; i<0; i++) {
            sum += i;
            queue.add(i);
        }
        
        if (sum == total) {
            return queue.stream().mapToInt(Integer::intValue).toArray();
        } 
        
        for(int i=0; i<=1000; i++) {
            int remove = queue.poll();
            queue.add(i);
            
            sum = sum - remove + i;
            
            if (sum == total) 
                break;
        }
        
        return queue.stream().mapToInt(Integer::intValue).toArray();

    }
}