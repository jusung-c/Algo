import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static boolean[][] visit;
    static int[][] dir = new int[][]{
            {1, 0}, {0, 1},
            {-1, 0}, {0, -1}
    };

    static int[][] map;
    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void pro() throws IOException {
        int max = 1;

        for (int h = 1; h <= 100; h++) {
            visit = new boolean[N + 1][N + 1];
            int ans = 0;
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    if (map[a][b] <= h) continue;
                    if (visit[a][b]) continue;
                    dfs(a, b, h);
                    ans++;
                }
            }

            max = Math.max(max, ans);
        }

        bw.write(max + " ");

    }

    private static void dfs(int a, int b, int h) {
        visit[a][b] = true;

        for (int k = 0; k < 4; k++) {
            int nx = a + dir[k][0];
            int ny = b + dir[k][1];

            if (nx < 1 || ny < 1 || nx > N || ny > N) continue;
            if (map[nx][ny] <= h) continue;
            if (visit[nx][ny]) continue;

            dfs(nx, ny, h);
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
