import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int T, N;
    static int[][] map, dist;
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
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine());
            Point end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            map = new int[N][N];
            dist = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dist[i][j] = -1;
                }
            }

            bfs(start, end);
            bw.write(dist[end.x][end.y] + " ");
            bw.newLine();
        }
    }

    private static void bfs(Point start, Point end) throws IOException {
        Queue<Point> que = new LinkedList<>();
        que.add(start);
        dist[start.x][start.y] = 0;

        while (!que.isEmpty()) {
            Point p = que.poll();

            for (int d = 0; d < 8; d++) {
                int nx = p.x + dir[d][0];
                int ny = p.y + dir[d][1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (dist[nx][ny] != -1) continue;

                que.add(new Point(nx, ny));
                dist[nx][ny] = dist[p.x][p.y] + 1;
            }
        }
    }

    private static void pro() throws IOException {


    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
