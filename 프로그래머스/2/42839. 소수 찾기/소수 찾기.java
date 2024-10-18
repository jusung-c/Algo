import java.util.*;

class Solution {
    static Set<Integer> answer;
    static boolean[] visit;
    
    public boolean isPrime(int num) {
        if (num <= 1) return false;
        
        for (int i=2; i<num; i++)
            if (num % i == 0) return false;
        
        return true;
    }
    
    public boolean isFinish() {
        for (boolean b : visit) 
            if (!b) return false;
        return true;
    }
    
    public void getNum(int num, int[] input) {
        // 소수인지 판별
        if (isPrime(num)) answer.add(num);
        
        // 종이 조각을 다 사용했으면 탈출
        if (isFinish()) return;
        
        // 다음 경우의 수
        for (int i=0; i<input.length; i++) {
            if (visit[i]) continue;
            
            int next = num * 10 + input[i];
            visit[i] = true;
            getNum(next, input);
            visit[i] = false;
        }
    }
    
    public int solution(String numbers) {
        answer = new HashSet<>();
        visit = new boolean[numbers.length()];
        
        // 1. 숫자 조각으로 분리
        int[] nums = numbers.chars().map(c -> c - '0').toArray();
        // for (int i : nums) System.out.println(i);
        
        // 2. 모든 조합의 숫자를 만들면서 소수인지 판별하기
        getNum(0, nums);
        
        return answer.size();
    }
}