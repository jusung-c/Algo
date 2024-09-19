import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int N, M, ans, space;
    static int[][] map;
    static Point[] blank;
    static boolean[][] visit;
    static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = 0;
        space = 0;

        visit = new boolean[N][M];
        map = new int[N][M];
        blank = new Point[N * M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                // 벽을 세울 수 있는 좌표 저장
                if (map[i][j] == 0) {
                    blank[space] = new Point(i, j);
                    space++;
                };
            }
        }
    }

    private static void pro() throws IOException {
        dfs(0, 0);

        bw.write(ans + " ");
    }

    static void dfs(int idx, int selected_cnt) {
        if (selected_cnt == 3) {
            // 바이러스 퍼뜨리기
            bfs();
            return;
        }

        // 더 이상 세울 수 있는 벽이 없는 경우
        if (idx >= space) return;

        // idx에 벽을 세우는 경우
        map[blank[idx].x][blank[idx].y] = 1;
        // 다음 벽 세우러 ㄱㄱ
        dfs(idx + 1, selected_cnt + 1);

        // idx에 벽을 안 세우는 경우
        map[blank[idx].x][blank[idx].y] = 0;
        // 다음 벽 세우러 ㄱㄱ
        dfs(idx + 1, selected_cnt);

    }

    private static void bfs() {
        Queue<Point> que = new LinkedList<>();

        // 모든 바이러스들을 시작점으로 넣기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 방문 배열 초기화
                visit[i][j] = false;

                if (map[i][j] == 2) {
                    que.add(new Point(i, j));
                    visit[i][j] = true;
                }
            }
        }

        // 바이러스 전염 시작
        while (!que.isEmpty()) {
            Point p = que.poll();

            for (int d = 0; d < 4; d++) {
                int nx = p.x + dir[d][0];
                int ny = p.y + dir[d][1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (map[nx][ny] != 0) continue;
                if (visit[nx][ny]) continue;

                que.add(new Point(nx, ny));
                visit[nx][ny] = true;
            }
        }

        // 전염 완료 후 안전 영역 크기 계산
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 이 때 전염된 구역을 제외하기 위해 방문처리 여부를 확인해줘야 한다.
                if (map[i][j] == 0 && !visit[i][j]) cnt++;
            }
        }

        ans = Math.max(ans, cnt);
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
