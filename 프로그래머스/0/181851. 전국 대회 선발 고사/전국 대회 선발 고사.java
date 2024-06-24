import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        Map<Integer, Integer> map = new HashMap<>();   
        
        for (int i = 0; i < attendance.length; i++) {
            if (attendance[i]) map.put(i, rank[i]);
        }
        
        List<Integer> keySet = new ArrayList<>(map.keySet());
        
        keySet.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1).compareTo(map.get(o2));
            }
        });
        
        return 10000 * keySet.get(0) + 100 * keySet.get(1) + keySet.get(2);
    }
}
