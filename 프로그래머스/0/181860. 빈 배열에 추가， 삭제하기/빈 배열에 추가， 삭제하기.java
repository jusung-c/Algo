import java.util.*;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int i=0; i<arr.length; i++) {
            if (!flag[i]) {
                for (int j=0; j<arr[i]; j++) {
                    answer.remove(answer.size() - 1);
                }
            } else {
                for (int j=0; j<2 * arr[i]; j++) {
                    answer.add(arr[i]);
                }
            }
            
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}