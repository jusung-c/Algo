class Solution {
    // 상, 하, 좌, 우
    static int[][] dir = new int[][] {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
    
        for (int room=0; room<5; room++) {
            String[] place = places[room];
            answer[room] = 1;
            
            // 1. 문자열로 주어진 대기실을 이차원 배열로 변환
            char[][] map = new char[place.length][];
            for (int r=0; r<place.length; r++) {
                map[r] = place[r].toCharArray();
            }
            
            // 2. 응시자들이 거리두기를 잘 지켰는지 검증한다.
            answer[room] = isOk(map) ? 1 : 0;
        }
        
        return answer;
    }
    
    public boolean isOk(char[][] map) {
        for (int r=0; r<map.length; r++) {
            for (int c=0; c<map[r].length; c++) {
                // 응시자들만 체크
                if (map[r][c] != 'P') continue;
                
                // 거리두기를 지켰는지 체크 (한명이라도 어길 시 바로 false)
                if (!isOk(map, r, c)) return false;
            }
        }
        
        return true;
    }
    
    public boolean isOk(char[][] map, int r, int c) {
        for (int d=0; d<4; d++) {
            // 상하좌우 방향으로 체크
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            
            if (nr < 0 || nc < 0 || nr >=5 || nc >= 5) continue;
            if (map[nr][nc] == 'P') return false;
            if (map[nr][nc] == 'X') continue;
            
            // 해당 방향에서 다시 상하좌우 체크. 단, 이전 방향을 제외
            if (!check(map, nr, nc, d)) return false;
        }
        
        return true;
    }
    
    public boolean check(char[][] map, int r, int c, int prev) {
        for (int d=0; d<4; d++) {
            int execlude = -1;
            
            switch (prev) {
                case 0: execlude = 1; break;
                case 1: execlude = 0; break;
                case 2: execlude = 3; break;
                case 3: execlude = 2; break;
            }
            
            if (d == execlude) continue;
            
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            
            if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5) continue;
            if (map[nr][nc] == 'P') return false;
        }
        
        return true;
    }
}