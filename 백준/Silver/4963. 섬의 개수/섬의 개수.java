import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int w, h, cnt;
    static int[][] map;
    static boolean[][] visit;
    static int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0},
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public static void init() throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            cnt = 0;

            if (w == 0 || h == 0) break;

            map = new int[h][w];
            visit = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            pro();

            bw.write(cnt + " ");
            bw.newLine();
        }
    }

    private static void pro() throws IOException {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    cnt++;
                    dfs(i, j);
                }
            }
        }

    }

    private static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int d = 0; d < 8; d++) {
            int nx = x + dir[d][0];
            int ny = y + dir[d][1];

            if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
            if (map[nx][ny] == 0) continue;
            if (visit[nx][ny]) continue;

            dfs(nx, ny);
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        bw.close();
    }
}
