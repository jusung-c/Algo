class Solution {
    // 상좌우하 순서
    private static final int[] dx = {0, -1, 1, 0};
    private static final int[] dy = {-1, 0, 0, 1};
    
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for (int i=0; i<answer.length; i++) {
            String[] place = places[i];
            
            // 1. 문자열로 주어진 대기실을 이차원 배열로 변환한다.
            char[][] map = new char[place.length][];
            
            for (int j=0; j<place.length; j++) {
                map[j] = place[j].toCharArray();
            }
            
            // 2. 거리두기가 잘 지켜졌는지 검증한다.
            answer[i] = isDistanced(map) ? 1 : 0;
        }        
        
        return answer;
    }
    
    public boolean isDistanced(char[][] map) {
        for (int y=0; y<map.length; y++) {
            for (int x=0; x<map[y].length; x++) {
                if (map[y][x] != 'P') continue;
                
                // 거리두기 검사
                if (!isDistanced(map, x, y)) return false;
            }
        }        
        
        return true;
    }
    
    public boolean isDistanced(char[][] map, int x, int y) {
        
        for(int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            // map의 범위를 벗어나는 경우 무시
            if (ny < 0 || ny >= map.length ||
                nx < 0 || nx >= map.length) continue;
            
            switch (map[ny][nx]) {
                case 'P':
                    return false;
                case 'O':
                    if (isNext(map, nx, ny, 3 - d)) return false;
                    break;
            }
        }
        
        return true;
    }
    
    public boolean isNext(char[][] map, int x, 
                          int y, int exclude) {
        
        for (int d=0; d<4; d++) {
            if (exclude == d) continue;
            
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            // map의 범위를 벗어나는 경우 무시
            if (ny < 0 || ny >= map.length ||
                nx < 0 || nx >= map[ny].length) continue;
            
            // 사람이 있을 경우 
            if (map[ny][nx] == 'P') return true;
        }
        
        return false;
    }
}