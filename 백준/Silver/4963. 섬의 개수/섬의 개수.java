import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;
    static int w, h;
    static boolean[][] visit;
    static int[][] dir = {
            {1, 0}, {0, 1},
            {-1, 0}, {0, -1},
            {1, 1}, {-1, -1},
            {1, -1}, {-1, 1}
    };
    static int[][] map;

    public static void init() throws IOException {
        map = new int[w + 1][h + 1];
        visit = new boolean[w + 1][h + 1];

        for (int i = 1; i <= h; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= w; j++) {
                int a = Integer.parseInt(st.nextToken());

                map[j][i] = a;
            }
        }

        pro();
    }

    private static void pro() throws IOException {
        int ans = 0;
        for (int x = 1; x <= w; x++) {
            for (int y = 1; y <= h; y++) {
                if (map[x][y] == 0) continue;
                if (visit[x][y]) continue;

                dfs(x, y);
                ans++;
            }
        }

        bw.write(ans+"\n");

    }

    private static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if (nx < 1 || ny < 1 || nx > w || ny > h) continue;
            if (visit[nx][ny]) continue;
            if (map[nx][ny] == 0) continue;
            dfs(nx, ny);

        }
    }

    public static void main(String[] args) throws Exception {

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            init();
        }

        bw.close();
    }
}
