import java.util.*;

class Solution {
    private static final int[] dx = {0, 1, -1};
    private static final int[] dy = {1, 0, -1};
    
    public int[] solution(int n) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[][] map = new int[n][n];
        int v = 1;
        int y = 0;
        int x = 0;
        int d = 0;
        
        // 1. 방향 순서대로 진행하면서 칸 채우기
        while (true) {
            map[y][x] = v++;
            
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            // 범위 및 방문 체크
            if (nx == n || nx == -1 || ny == n | ny == -1 ||
               map[ny][nx] != 0) {
                
                d = (d+1) % 3;
                nx = x + dx[d];
                ny = y + dy[d];
                
                // 범위 및 방문 체크
                if (nx == n || nx == -1 || ny == n | ny == -1 ||
                    map[ny][nx] != 0) break;
                
                x = nx;
                y = ny;
            }
            
            x = nx;
            y = ny;
            
        }
        
        // 2. 하나의 정수 배열로 변환하기
        for(int[] list : map) {
            for(int num : list) {
                if (num != 0) answer.add(num);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
        
    }
}

