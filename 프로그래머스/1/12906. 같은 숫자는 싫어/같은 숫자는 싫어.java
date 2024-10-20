import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        // 0~9로 이루어진 배열
        // 연속적으로 나타나는 숫자는 하나만 남기고 모두 제거
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        // 1. 이전 원소와 동일한 경우엔 무시하면서 넣기
        int prev = arr[0];
        answer.add(prev);
        
        for (int i=1; i<arr.length; i++) {
            if (arr[i] == prev) continue;
            prev = arr[i];
            answer.add(prev);
        }

        return answer.stream().mapToInt(i->i).toArray();
    }
}