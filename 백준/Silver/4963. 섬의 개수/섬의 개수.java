import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int w, h, cnt;
    static int[][] map;
    static boolean[][] visit;
    static int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0},
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

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
//                    dfs(i, j);
                    bfs(i, j);
                }
            }
        }

    }

    private static void bfs(int x, int y) {
        Queue<Point> que = new LinkedList<>();

        que.add(new Point(x, y));
        visit[x][y] = true;

        while (!que.isEmpty()) {
            Point p = que.poll();

            for (int d = 0; d < 8; d++) {
                int nx = p.x + dir[d][0];
                int ny = p.y + dir[d][1];

                if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                if (visit[nx][ny]) continue;
                if (map[nx][ny] == 0) continue;

                que.add(new Point(nx, ny));
                visit[nx][ny] = true;
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
