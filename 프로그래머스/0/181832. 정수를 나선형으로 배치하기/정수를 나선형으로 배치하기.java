class Solution {
    public int[][] solution(int n) {
        int[][] arr = new int[n][n];
        
        int row = 0;
        int col = 0;
        arr[row][col] = 1;
        
        for (int i=2; i<=n*n; i++) {    
            if (col + 1 < n && arr[row][col+1] == 0 && (row == 0 || arr[row-1][col] != 0)) {
                col++;
                arr[row][col] = i;
            } else if (row + 1 < n && arr[row+1][col] == 0) {
                row++;
                arr[row][col] = i;
            } else if (col - 1 >= 0 && arr[row][col-1] == 0) {
                col--;
                arr[row][col] = i;
            } else if (row - 1 >= 0 && arr[row-1][col] == 0) {
                row--;
                arr[row][col] = i;
            }
            
        }
        
        return arr;
    }
}