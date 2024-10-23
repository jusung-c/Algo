import java.util.*;

class Solution {
    class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    int[][] map;
    int[][] dist;
    int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public void bfs(Point p, int[][] rectangle, Point target) {
        Queue<Point> que = new LinkedList<>();
        que.add(p);
        dist[p.x][p.y] = 0;
        
        while(!que.isEmpty()) {
            p = que.poll();
            
            if (p == target) break;
            
            for (int d=0; d<4; d++) {
                int nx = p.x + dir[d][0];
                int ny = p.y + dir[d][1];
                
                if (nx < 0 || ny < 0 || nx >= 102 || ny >= 102) continue;
                if (map[nx][ny] != 1) continue;
                if (dist[nx][ny] != -1) continue;
                
                dist[nx][ny] = dist[p.x][p.y] + 1;
                que.add(new Point(nx, ny));
            }
        }
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        map = new int[102][102];
        for (int[] m : map) Arrays.fill(m, -1);
        
        // 1. 직사각형들의 정보를 map에 저장한다. (2배 확장된 map을 사용한다.)
        for (int t=0; t<rectangle.length; t++) {
            int r1 = rectangle[t][0] * 2;
            int c1 = rectangle[t][1] * 2;
            int r2 = rectangle[t][2] * 2;
            int c2 = rectangle[t][3] * 2;
            
            // 1-1. 테두리 위치값을 1로 설정
            for (int i=r1; i<=r2; i++) {
                if (map[i][c1] != 0) map[i][c1] = 1;
                if (map[i][c2] != 0) map[i][c2] = 1;
            }
            for (int i=c1; i<=c2; i++) {
                if (map[r1][i] != 0) map[r1][i] = 1;
                if (map[r2][i] != 0) map[r2][i] = 1;
            }
            
            // 1-2. 테두리 안의 값을 0으로 설정
            for (int i=r1+1; i<r2; i++) {
                for(int j=c1+1; j<c2; j++) {
                    map[i][j] = 0;
                }
            }
        }
        
        // for (int r=0; r<=20; r++) { 
        //     for(int c=0; c<=20; c++) 
        //         System.out.print(map[r][c] >= 0 ? 
        //                          ("+" + map[r][c] + " ") : map[r][c] + " ");
        //     System.out.println();
        // }
        
        // 2. 시작점에서 시작해서 도착점까지의 최단 거리를 BFS로 구한다.
        dist = new int[102][102];
        for (int[] d : dist) Arrays.fill(d, -1);
        
        bfs(new Point(characterX * 2, characterY * 2), rectangle, new Point(itemX * 2, itemY * 2));
        
        // for (int r=0; r<=20; r++) { 
        //     for(int c=0; c<=20; c++) 
        //         System.out.print(dist[r][c] >= 0 ? 
        //                          ("+" + dist[r][c] + " ") : dist[r][c] + " ");
        //     System.out.println();
        // }
        
        // 3. 아이템까지의 최단거리 반환
        return dist[itemX * 2][itemY * 2] / 2;
    }
}