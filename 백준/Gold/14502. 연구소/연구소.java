import java.io.*;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, B, ans;
    static int[][] map, blank;
    static int[][] dir = new int[][]{
            {1, 0}, {0, 1},
            {-1, 0}, {0, -1}
    };
    static boolean[][] visit;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[N + 1][M + 1];
        blank = new int[N * M + 1][2];
    }

    // 바이러스 퍼뜨리기!
    static void bfs() {
        Queue<Integer> Q = new LinkedList<>();

        // 모든 바이러스들을 시점점으로 큐에 넣어주기
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                visit[i][j] = false;

                // 만약 바이러스가 있을 경우
                if (map[i][j] == 2) {
                    Q.add(i);
                    Q.add(j);
                    visit[i][j] = true;
                }
            }
        }

        // BFS
        while (!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();

            // 상하좌우 바이러스 퍼지기
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if (nx <1 || ny<1 || nx>N || ny>M) continue;
                if (map[nx][ny] != 0) continue;
                if (visit[nx][ny]) continue;

                visit[nx][ny] = true;
                Q.add(nx);
                Q.add(ny);
            }
        }

        // 전염 완료. 안전영역 크기 계산 후 정답 갱신
        int cnt = 0;
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= M; j++)
                if (map[i][j] == 0 && !visit[i][j]) cnt++;

        ans = Math.max(ans, cnt);
    }

    // idx: idx 번째 빈 칸에 벽을 세울 지 말지 결정
    // selected_cnt: 이전까지 세운 벽의 개수
    static void dfs(int idx, int selected_cnt) {

        // 3개의 벽 모두 세운 상태
        if (selected_cnt == 3) {
            // 바이러스 퍼뜨리기
            bfs();
            return;
        }

        // 더 이상 세울 수 있는 벽이 없는 경우
        if (idx > B) return;

        // idx에 벽을 세우는 경우
        map[blank[idx][0]][blank[idx][1]] = 1;
        // 다음 벽 세우러 ㄱㄱ
        dfs(idx + 1, selected_cnt + 1);

        // idx에 벽을 안세우는 경우
        map[blank[idx][0]][blank[idx][1]] = 0;
        dfs(idx + 1, selected_cnt);

    }

    private static void pro() throws IOException {
        // 벽을 세울 수 있는, 즉 빈 칸의 개수 B개 모아놓기.
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 0) {
                    B++;
                    blank[B][0] = i;
                    blank[B][1] = j;
                }
            }
        }

        // 벽 3개 세우는 모든 방법 완전 탐색
        dfs(1, 0);

        // 정답 출력
        bw.write(ans + " ");

    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
