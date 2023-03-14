import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int T, N, M, K;
    static int[][] map;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean visit[][];


    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            visit = new boolean[N][M];
            map = new int[N][M];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
            }

            pro();
        }

    }

    private static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (map[nx][ny] == 0) continue;
            if (visit[nx][ny]) continue;

            dfs(nx, ny);
        }

    }

    private static void pro() throws IOException {
        int ans = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visit[i][j]) continue;
                if (map[i][j] == 0) continue;

                ans++;
                dfs(i, j);
            }
        }

        bw.write(ans + "\n");
    }

    public static void main(String[] args) throws Exception {
        init();

        bw.close();
    }
}
