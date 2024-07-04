import java.math.*;

class Solution {
    private int[] selected;
    private boolean[] visit;
    private int sum;
    private int N, M;
    
    public int solution(int balls, int share) {
        N = balls;
        M = share;
        
        selected = new int[M+1];
        
        rec_func(1, 0);
        
        return sum;
    }
    
    public void rec_func(int k, int prev) {
        if (k == M+1) {
            sum++;
        } else {
            for (int i=prev+1; i<=N; i++) {
                selected[k] = i;
                
                rec_func(k+1, i);
                
                selected[k] = 0;
            }
        }
    }
    
}