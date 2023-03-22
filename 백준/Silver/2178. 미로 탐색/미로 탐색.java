import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, ans;
    static int[][] map, dist;
    static int[][] dir = new int[][]{
            {1, 0}, {0, 1},
            {-1, 0}, {0, -1}
    };

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
    }

    private static void pro() throws IOException {
        Point S = new Point(0, 0);
        bfs(S);

        bw.write(dist[N - 1][M - 1] + " ");
    }

    private static void bfs(Point start) {
        Queue<Point> Q = new LinkedList<>();

        // dist 배열은 갈 수 없으면 -1 이므로 일단 -1로 초기화 시켜둔다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist[i][j] = -1;
            }
        }

        // 시작점을 Q에 넣고, visit 처리와 dist 값을 초기화한다.
        Q.add(start);
        dist[start.x][start.y] = 1;

        while (!Q.isEmpty()) {
            Point p = Q.poll();

            for (int k = 0; k < 4; k++) {
                int nx = p.x + dir[k][0];
                int ny = p.y + dir[k][1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (dist[nx][ny] != -1) continue;
                if (map[nx][ny] == 0 ) continue;

                Q.add(new Point(nx, ny));
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
