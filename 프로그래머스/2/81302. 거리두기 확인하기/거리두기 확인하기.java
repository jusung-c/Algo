class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        // 1. 각 대기실별로 반복해 거리두기를 지킨 대기실인지 판단
        for (int r = 0; r < places.length; r++) {

            // 2. 주어진 대기실 정보를 char[][]로 변환
            char[][] room = new char[places.length][places[r].length];

            for (int i = 0; i <places[r].length; i++) {
                room[i] = places[r][i].toCharArray();
            }

            // 3. 모든 좌석을 돌면서 사람일 경우 거리두기 체크
            answer[r] = checkRoom(room) ? 1:0;
        }

        return answer;
    }

    private boolean checkRoom(char[][] room) {
        for (int y = 0; y < room.length; y++) {
            for (int x = 0; x < room[y].length; x++) {
                // 사람일 경우 체크 시작
                if (room[y][x] == 'P') {
//                    System.out.println("y = " + y + " x = " + x);

                    if(!checkRoom(room, y, x)) return false;
                }
            }
        }

        return true;
    }

    private boolean checkRoom(char[][] room, int y, int x) {
//        System.out.println("호출!");
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            // room의 범위를 벗어나는 경우 무시
            if (ny < 0 || ny >= room.length ||
                    nx < 0 || nx >= room.length) continue;

            switch (room[ny][nx]) {
                case 'P': return false;
                case 'X': break;
                case 'O':
                    if (isNext(room, ny, nx)) return false;
                    break;
            }
        }

        return true;
    }

    private boolean isNext(char[][] room, int y, int x) {
        int cnt = 0;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            // room의 범위를 벗어나는 경우 무시
            if (ny < 0 || ny >= room.length ||
                    nx < 0 || nx >= room.length) continue;

            if (room[ny][nx] == 'P') cnt++;
        }

        return cnt > 1;
    }


    public static void main(String[] args) {
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        Solution solution = new Solution();
        solution.solution(places);
    }
}