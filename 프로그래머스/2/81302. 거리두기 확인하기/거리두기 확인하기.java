class Solution {
    // 상, 좌, 우, 하 순서
    int[] dx = {0, -1, 1, 0};
    int[] dy = {-1, 0, 0, 1};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            String[] place = places[i];

            // 1. 문자열로 주어진 대기실을 이차원 char 배열로 변환
            char[][] map = new char[place.length][];

            for (int j = 0; j < place.length; j++) {
                map[j] = place[j].toCharArray();
            }

            // 2. 거리두기 체크
            answer[i] = isDistanced(map) ? 1 : 0;
        }

        // 1. char[][] map으로 변환
        char[][] map = new char[5][5];


        return answer;
    }

    private boolean isDistanced(char[][] map) {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                if (map[y][x] != 'P') continue;

                // 거리두기 검사
                if (!isDistanced(map, x, y)) return false;
            }
        }

        return true;
    }

    private boolean isDistanced(char[][] map, int x, int y) {

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            // map 범위 체크
            if (nx == 5 || nx == -1 || ny == 5 || ny == -1) continue;

            // 사람이 있으면 바로 false, 파티션은 고려 안함, 빈책상일 경우 빈책상 주변 탐색
            switch (map[ny][nx]) {
                case 'P':
                    return false;
                case 'X':
                    break;
                case 'O':
                    // 빈책상 주변에 사람이 있는지 확인 -> 있다면 거리두기 어긴 것
                    if (existSidePeople(map, nx, ny, 3 - d)) return false;
                    break;
            }
        }

        return true;
    }

    private boolean existSidePeople(char[][] map, int x, int y, int exclude) {

        for (int d = 0; d < 4; d++) {
            // 역방향은 제외
            if (exclude == d) continue;

            int nx = x + dx[d];
            int ny = y + dy[d];

            // map 범위 체크
            if (nx == 5 || nx == -1 || ny == 5 || ny == -1) continue;

            // 사람이 있을 경우 거리두기 안 지킨 것
            if (map[ny][nx] == 'P') return true;
        }

        return false;
    }
}