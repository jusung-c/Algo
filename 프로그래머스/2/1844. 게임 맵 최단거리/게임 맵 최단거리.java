// (1, 1)에서 시작해 (R, C)에 가장 빠르게 도착하는 방법
// 상하좌우로 이동 가능하며 1로 구성된 칸으로만 이동할 수 있다.
// 도착이 불가능하다면 -1을 리턴

import java.util.*;

class Solution {
    class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    int R, C;
    int[][] dist;
    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public void bfs(Point p, int[][] maps) {
        Queue<Point> que = new LinkedList<>();
        que.add(p);
        dist[p.x][p.y] = 1;
        
        while(!que.isEmpty()) {
            p = que.poll();
            
            for (int d=0; d<4; d++) {
                int nx = p.x + dir[d][0];
                int ny = p.y + dir[d][1];
                
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (dist[nx][ny] != -1) continue;
                if (maps[nx][ny] != 1) continue;
                
                que.add(new Point(nx, ny));
                dist[nx][ny] = dist[p.x][p.y] + 1;
            }
            
            
        }
    }
    
    public int solution(int[][] maps) {
        R = maps.length;
        C = maps[0].length;
        
        // 거리 배열 초기화
        dist = new int[R][C];
        for (int r=0; r<R; r++)
            for (int c=0; c<C; c++)
                dist[r][c] = -1;
        
        // 1. (0, 0)에서 시작해서 최단 거리 기록하는 BFS 시작
        bfs(new Point(0, 0), maps);
        
        // 2. 목적지까지의 최단거리 반환
        return dist[R-1][C-1];
    }
}