import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        ArrayList<Integer> answer = new ArrayList<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();
        
        for(int i=0; i<numlist.length; i++) {
            addValue(map, Math.abs(n - numlist[i]), numlist[i]);
        }
        
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            for(Integer i : entry.getValue()) {
                answer.add(i);
            }
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
    
    // Map에 값 추가
    public void addValue(Map<Integer, List<Integer>> map, Integer key, Integer value) {
        List<Integer> values = map.getOrDefault(key, new ArrayList<>());
        
        values.add(value);
        
        // 내림차순
        values.sort(Comparator.reverseOrder());
        
        map.put(key, values);
    }
}