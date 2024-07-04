class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int x = 0;
        int y = 0;
        
        for (String s : keyinput) {
            switch (s) {
                case "left": x = Math.abs(x-1) > board[0]/2 ? x : x-1; break;
                case "right": x = Math.abs(x+1) > board[0]/2 ? x : x+1; break;
                case "up": y = Math.abs(y+1) > board[1]/2 ? y : y+1; break;
                case "down": y = Math.abs(y-1) > board[1]/2 ? y : y-1; break;
            }
        }
        
        return new int[]{x, y};
    }
}