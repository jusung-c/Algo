class Solution {
    public int[][] solution(int n) {
        int[][] arr = new int[n][n];
        
        int row = 0;
        int col = 0;
        int val = 1;
        int direction = 0;
        
        while (val <= n*n) {
            arr[row][col] = val++;
            
            if (direction == 0 ) {
                if (col + 1 >= n || arr[row][col+1] != 0) {
                    direction = 1;
                    row++;
                } else {
                    col++;
                }
            } else if (direction == 1) {
                if (row + 1 >= n || arr[row+1][col] != 0) {
                    direction = 2;
                    col--;
                } else {
                    row++;
                }
                
            } else if (direction == 2) {
                if (col <= 0 || arr[row][col-1] != 0) {
                    direction = 3;
                    row--;
                } else {
                    col--;
                }
                
            } else {
                if (row <= 0 || arr[row-1][col] !=0) {
                    direction = 0;
                    col++;
                } else {
                    row--;
                }

                
            }
            
            
            
        }
        
        return arr;
    }
}