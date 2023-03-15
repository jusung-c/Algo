import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int a, b, sheep, wolf;
    static String[] arr;
    static boolean[][] visit;
    static int[][] dir = {
            {1, 0}, {0, 1},
            {-1, 0}, {0, -1}
    };

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N][M];

        arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        sheep = 0;
        wolf = 0;
    }

    private static void pro() throws IOException {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (visit[x][y]) continue;
                char c = arr[x].charAt(y);

                if (c == '#') continue;

                a = 0;
                b = 0;
                dfs(x, y, c);

                if (a > b) sheep += a;
                else wolf += b;

            }
        }

        bw.write(sheep + " " + wolf);
    }

    private static void dfs(int x, int y, char c) {
        visit[x][y] = true;

        if (c == 'o') a++;
        if (c == 'v') b++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (c == '#') continue;
            if (visit[nx][ny]) continue;

            dfs(nx, ny, arr[nx].charAt(ny));
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
