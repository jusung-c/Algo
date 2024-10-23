import java.util.*;

class Solution {
    static int[] selected;
    static int cnt;
    
    public int cal(int[] selected, int[] numbers) {
        int result = 0;

        for (int i=0; i<selected.length; i++) {
            
            switch (selected[i]) {
                case 1:
                    result += numbers[i];
                    break;
                case 2:
                    result -= numbers[i];
                    break;
            }
        }
        
        return result;
    }
    
    public void dfs(int k, int[] numbers, int target) {
        // 2. 연산자를 다 고른 경우 적용해 target이 되는지 확인
        if (k == numbers.length) {
            if (target == cal(selected, numbers)) cnt++;
            return;
        }
        
        for (int i=1; i<=2; i++) {
            selected[k] = i;
            dfs(k+1, numbers, target);
            selected[k] = 0;
        }
    }
        
    public int solution(int[] numbers, int target) {
        selected = new int[numbers.length];
        cnt = 0;
        
        // 1. 4종류의 연산자를 중복을 허용해서 순서있게 N개를 뽑아서 나열
        dfs(0, numbers, target);
        
        return cnt;
    }
}