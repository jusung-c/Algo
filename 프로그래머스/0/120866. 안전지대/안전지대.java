class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        
        for(int x=0; x<board.length; x++) {
            for(int y=0; y<board[x].length; y++) {
                if (check(x, y, board)) {
                    System.out.println("(x, y): (" +x +", " + y + ")" + " 안전해요!");
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    public boolean check(int x, int y, int[][] board) {
        int[] dx = {0, 0, 0, 1, 1, 1, -1, -1, -1};
        int[] dy = {0, 1, -1, 0, 1, -1, 0, 1, -1};
        
        for(int i=0; i<9; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length)
                continue;
            
            if (board[nx][ny] == 1) return false;           
        }
        
        return true;
    }
}