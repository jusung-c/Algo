import java.util.*;

class Solution {
    public int[][] solution(int n) {
        return hanoi(n, 1, 3).toArray(new int[0][]);
        
    }
    
    // 상태를 매개변수로 받는 재귀 메서드
    private List<int[]> hanoi(int n, int from, int to) {
        // 종료 조건
        if (n==1) return List.of(new int[] {from, to});
        
        // 빈 기둥 번호 조회
        int empty = 6 - from - to;
        
        List<int[]> result = new ArrayList<>();
        
        result.addAll(hanoi(n-1, from, empty));    // 1단계
        result.addAll(hanoi(1, from, to));         // 2단계
        result.addAll(hanoi(n-1, empty, to));      // 3단계
        
        return result;
    }
}