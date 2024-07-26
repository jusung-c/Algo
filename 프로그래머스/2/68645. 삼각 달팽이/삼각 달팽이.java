import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

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

            // 방향을 바꿀 것인지 진행한 방향 그대로 갈 것인지 판단해야 한다.

            // 일단 방향 그대로 진행할 경우 범위 및 이미 방문한 곳인지 확인한다.
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx == n || nx == -1 || ny == n || ny == -1
                    || map[ny][nx] != 0) {

                // 방향 전환해야할 경우 전환할 방향도 마찬가지로 검증한다.
                d = (d + 1) % 3;
                nx = x + dx[d];
                ny = y + dy[d];
                if (nx == n || nx == -1 || ny == n || ny == -1
                        || map[ny][nx] != 0) {

                    // 방향을 전환해도 이동할 수 없다면 무한 루프를 탈출한다.
                    break;
                }
            }
            
            x = nx;
            y = ny;
            
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j <= i; j++) {
                answer.add(map[i][j]);
            }
        }

        return answer.stream()      // Stream<Integer>
                .mapToInt(Integer::intValue)    // IntStream
                .toArray();         // int[]
    }
}