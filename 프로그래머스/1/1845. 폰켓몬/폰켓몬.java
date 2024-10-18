// N(1 <= N <= 10,000. 짝수)개 숫자 중 N/2개를 고른다.
// 이 때 가장 많은 종류의 숫자를 선택하는 방법을 찾아라
// 각 숫자는 1 이상 20만 이하의 자연수

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        // 카드 정보 map 저장
        for (int i : nums) 
            map.put(i, map.getOrDefault(map.get(i), 0) + 1);
        
        return map.size() > nums.length / 2 ? nums.length/2 : map.size();
    }
}