class Solution {
    public int solution(int[][] dots) {
        int[] arr = new int[2];
        
        int x = dots[0][0];
        int y = dots[0][1];
        
        for (int i=1; i<dots.length; i++) {
            if (x == dots[i][0]) {
                arr[0] = Math.abs(y - dots[i][1]);
            }
            
            if (y == dots[i][1]) {
                arr[1] = Math.abs(x - dots[i][0]);
            }
            
        }
        
        return arr[0] * arr[1];
    }
}