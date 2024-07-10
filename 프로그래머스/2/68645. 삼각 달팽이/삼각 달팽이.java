import java.util.*;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[][] map = new int[n][n];
        int y = 0;
        int x = 0;
        int v = 1;
        
        // 1. 방향 순서대로 진행하면서 칸 채우기
        while (true) {
            // 아래로 이동
            while (true) {
                map[y][x] = v++;
                
                if (y+1 >= n || map[y+1][x] != 0) break;
                y++;
            }
            if (x+1 >= n || map[y][x+1] != 0) break;
            x++;
            
            // 오른쪽으로 이동
            while (true) {
                map[y][x] = v++;
                
                if (x+1 >= n || map[y][x+1] != 0) break;
                x++;
            }
            if (map[y-1][x-1] != 0) break;
            x--;
            y--;
            
            // 왼쪽 대각선 위로 이동
            while (true) {
                map[y][x] = v++;
                
                if (map[y-1][x-1] != 0) break;
                x--;
                y--;
            }
            if (y+1 >=n || map[y+1][x] != 0) break;
            y++;
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


// 1
// 2 9