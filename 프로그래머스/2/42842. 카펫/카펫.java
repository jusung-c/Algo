class Solution {
    
    public int[] solution(int brown, int yellow) {
        
        for (int x=3; x<=5000; x++) {
            for (int y=3; y<=x; y++) {
                // 조건 검사
                int b_cnt = 2*x + 2*y - 4;
                int y_cnt = (x-2)*(y-2);
                
                if (b_cnt == brown && y_cnt == yellow) {
                    return new int[] {x, y};
                }
            }
        }
        
        return null;
    }
}