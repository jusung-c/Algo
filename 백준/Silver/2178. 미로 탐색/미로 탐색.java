import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int N, M;
    static int[][] map, dist;
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

        map = new int[N + 1][M + 1];
        visit = new boolean[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = s.charAt(j - 1) - '0';
            }
        }

        dist = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dist[i][j] = -1;
            }
        }
    }

    private static void bfs(Point p) {
        Queue<Point> que = new LinkedList<>();
        que.add(p);
        visit[p.x][p.y] = true;
        dist[p.x][p.y] = 1;

        while (!que.isEmpty()) {
            p = que.poll();

            for (int d = 0; d < 4; d++) {
                int nx = p.x + dir[d][0];
                int ny = p.y + dir[d][1];

                if (nx < 1 || ny < 1 || nx > N || ny > M) continue;
                if (visit[nx][ny]) continue;
                if (map[nx][ny] != 1) continue;

                que.add(new Point(nx, ny));
                visit[nx][ny] = true;
                dist[nx][ny] = dist[p.x][p.y] + 1;
            }
        }
    }

    private static void pro() throws IOException {
        Point start = new Point(1, 1);

        bfs(start);

        bw.write(dist[N][M] + " ");
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
