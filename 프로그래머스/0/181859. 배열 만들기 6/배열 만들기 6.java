import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int index = -1;
        
        for(int i=0; i<arr.length; i++) {
            if(list.isEmpty()) {
                list.add(arr[i]);
                continue;
            } else {
                if (list.get(list.size()-1) == arr[i]) {
                    list.remove(list.size()-1);
                } else {
                    list.add(arr[i]);
                }
            }
        }
        
        if (list.isEmpty()) {
            return new int[]{-1};
        }
        
        return list.stream().mapToInt(i -> i).toArray();
        
    }
}