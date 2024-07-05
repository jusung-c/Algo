import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int max = 0;
        Arrays.sort(array);
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(array[0], 1);
        
        for(int i=1; i<array.length; i++) {
            if (array[i] == array[i-1]) {
                map.put(array[i], map.get(array[i])+1);
            } else {
                map.put(array[i], 1);
            }
        }
        
        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (max < e.getValue()) {
                max = e.getValue();
                answer = e.getKey();
            } else if (max == e.getValue()) {
                answer = -1;
            }
        }
        
        return answer;
    }
}