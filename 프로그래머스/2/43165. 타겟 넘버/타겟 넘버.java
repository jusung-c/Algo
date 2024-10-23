import java.util.*;

class Solution {
    int[] selected;
    int cnt;
    
    public int cal(int num, int op) {
        return op == 1 ? num : (-1)*num;
    }
    
    public void dfs(int k, int sum, int[] numbers, int target) {
        // 2. 연산자를 다 고른 경우 적용해 target이 되는지 확인
        if (k == numbers.length) {
            if (target == sum) cnt++;
            return;
        }
        
        for (int i=1; i<=2; i++) {
            selected[k] = i;
            sum += cal(numbers[k], i);
            dfs(k+1, sum, numbers, target);
            selected[k] = 0;
            sum -= cal(numbers[k], i);
        }
    }
        
    public int solution(int[] numbers, int target) {
        selected = new int[numbers.length];
        cnt = 0;
        
        // 1. 4종류의 연산자를 중복을 허용해서 순서있게 N개를 뽑아서 나열
        dfs(0, 0, numbers, target);
        
        return cnt;
    }
}