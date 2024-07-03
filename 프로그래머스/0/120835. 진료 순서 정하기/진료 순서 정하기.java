import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        
        int[] copy = Arrays.copyOf(emergency, emergency.length);
        Map<Integer, Integer> answer = new HashMap<>();
        
        Arrays.sort(copy);
        // copy: 0: 3, 1: 76, 2: 24
        
        for(int i=0; i<copy.length; i++) {
            answer.put(copy[i], copy.length - i);
        }

        for(int i=0; i<emergency.length; i++) {
            emergency[i] = answer.get(emergency[i]);
        }
        
        return emergency;
    }
}