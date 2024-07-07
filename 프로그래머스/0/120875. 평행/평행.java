class Solution {
    int N, M;
    int[] selected;
    int answer = 0;
    
    public int solution(int[][] dots) {
        
        N = 4;
        M = 2;
        selected = new int[M + 1];
        
        func(1, 1, dots);
        
        return answer;
    }
    
    public void func(int k, int prev, int[][] dots) {
        if (k == M + 1) {
            if (check(dots)) {
                answer = 1; 
            }
        } else {
            for (int i = prev; i <= N; i++) {
                selected[k] = i;
                
                func(k + 1, i + 1, dots);
                
                selected[k] = 0;
            }
        }
    }
    
    public boolean check(int[][] dots) {
        int[] unselected = new int[M + 1];
        
        int index = 1;
        for (int i = 1; i <= 4; i++) {
            if (i != selected[1] && i != selected[2])
                unselected[index++] = i;
        }
        
        // 기울기 구하기
        double a = (double) (dots[selected[1] - 1][1] - dots[selected[2] - 1][1]) / 
                          (dots[selected[1] - 1][0] - dots[selected[2] - 1][0]);
        
        double b = (double) (dots[unselected[1] - 1][1] - dots[unselected[2] - 1][1]) / 
                          (dots[unselected[1] - 1][0] - dots[unselected[2] - 1][0]);
        
        return a == b;
    }
}
