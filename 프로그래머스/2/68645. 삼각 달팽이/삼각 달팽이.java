import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    // 아래로 -> 오른쪽으로 -> 왼쪽 대각선 위로
    int[] dx = {0, 1, -1};
    int[] dy = {1, 0, -1};

    public int[] solution(int n) {
        int[] answer = {};

        // n x n 배열 생성
        int[][] map = new int[n][n];

        // map 채우기
        map = visit(map, n);

        return Arrays.stream(map)      // Stream<int[]>
                .flatMapToInt(Arrays::stream)   // Stream<IntStream>
                .filter(i -> i != 0)
                .toArray();
    }

    private int[][] visit(int[][] map, int n) {
        int v = 1;
        int d = 0;
        int x = 0;
        int y = 0;

        while (true) {
            // 방문
            map[y][x] = v++;

            // 진행했던 방향 그대로 진행할 수 있는지 판단
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx == n || nx == -1 || ny == n || ny == -1 || map[ny][nx] != 0) {

                // 진행할 수 없는 경우 다음 방향으로 진행할 수 있는지 체크
                d = (d + 1) % 3;
                nx = x + dx[d];
                ny = y + dy[d];

                // 다음 방향으로도 진행 못하면 탈출
                if (nx == n || nx == -1 || ny == n || ny == -1 || map[ny][nx] != 0) break;

            }

            // 정해진 다음 좌표로 설정
            x = nx;
            y = ny;
        }

        return map;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(4);
    }
}