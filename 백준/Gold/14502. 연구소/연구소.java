import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, ans, B;
    static int[][] map, blank;
    static int[][] dir = new int[][]{
            {1, 0}, {0, 1},
            {-1, 0}, {0, -1}
    };
    static boolean[][] visit;
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = -1;
        B = 0;

        map = new int[N + 1][M + 1];
        visit = new boolean[N + 1][M + 1];
        blank = new int[N * M + 1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void bfs() {
        Queue<Point> Q = new LinkedList<>();

        // 방문 리스트 초기화
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= M; j++) visit[i][j] = false;

        // 바이러스 시작점들 큐에 넣기
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 2) {
                    Q.add(new Point(i, j));
                    visit[i][j] = true;
                }
            }
        }

        // BFS 진행
        while (!Q.isEmpty()) {
            Point p = Q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dir[i][0];
                int ny = p.y + dir[i][1];

                if (nx<1 || ny<1 || nx>N || ny>M) continue;
                if (visit[nx][ny]) continue;
                if (map[nx][ny] != 0) continue;

                visit[nx][ny] = true;
                Q.add(new Point(nx, ny));
            }
        }

        // 전염 완료 시 안전 구역 계산 후 정답 갱신
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 0 && !visit[i][j]) cnt++;
            }
        }
        ans = Math.max(ans, cnt);
    }

    private static void pro() throws IOException {
        // 벽을 세울 수 있는 빈칸의 개수 세기
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 0) {
                    B++;
                    blank[B][0] = i;
                    blank[B][1] = j;
                }
            }
        }

        dfs(1, 0);

        // 정답 출력
        bw.write(ans + " ");

    }

    static void dfs(int idx, int wall_cnt) {
        // idx 번째 빈칸 위키 정보
        int x = blank[idx][0];
        int y = blank[idx][1];

        // 벽 3개를 모두 세웠을 경우
        if (wall_cnt == 3) {
            // 바이러스 퍼뜨리기
            bfs();
            return;
        }

        // 더 이상 세울 수 있는 벽이 없는 경우
        if (idx > B) return;

        // idx에 벽을 세울 경우
        map[x][y] = 1;
        dfs(idx + 1, wall_cnt + 1);

        // idx에 벽을 세우지 않을 경우
        map[x][y] = 0;
        dfs(idx + 1, wall_cnt);
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
