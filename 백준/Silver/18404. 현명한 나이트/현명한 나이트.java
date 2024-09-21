import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int N, M;
    static int[][] map, dist;
    static Point start;
    static int[][] dir = new int[][]{{-2, 1}, {-2, -1}, {-1, 2}, {-1, -2},
            {1, 2}, {1, -2}, {2, 1}, {2, -1}};
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

        map = new int[N + 1][N + 1];
        dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dist[i][j] = -1;
            }
        }

        st = new StringTokenizer(br.readLine());
        start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

    }

    private static void pro() throws IOException {

        bfs(start);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            bw.write(dist[x][y] + " ");
        }
    }

    private static void bfs(Point start) {
        Queue<Point> que = new LinkedList<>();
        que.add(start);
        dist[start.x][start.y] = 0;

        while (!que.isEmpty()) {
            Point p = que.poll();

            for (int d = 0; d < 8; d++) {
                int nx = p.x + dir[d][0];
                int ny = p.y + dir[d][1];

                if (nx < 1 || ny < 1 || nx > N || ny > N) continue;
                if (dist[nx][ny] != -1) continue;

                que.add(new Point(nx, ny));
                dist[nx][ny] = dist[p.x][p.y] + 1;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
