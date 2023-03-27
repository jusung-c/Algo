import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int T, N;
    static int[][] dist;
    static int[][] dir = new int[][]{
            {-2, -1}, {-1, -2},
            {1, 2}, {2, 1},
            {-2, 1}, {-1, 2},
            {1, -2}, {2, -1}
    };


    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            dist = new int[N][N];

            // dist 초기화
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dist[i][j] = -1;
                }
            }

            // 시작점
            st = new StringTokenizer(br.readLine(), " ");
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());

            // 목적지
            st = new StringTokenizer(br.readLine(), " ");
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            bfs(sx, sy);

            bw.write(dist[ex][ey] + " \n");
        }

    }

    private static void bfs(int a, int b) {
        Queue<Integer> Q = new LinkedList<>();

        dist[a][b] = 0;
        Q.add(a);
        Q.add(b);

        while (!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();

            for (int k = 0; k < 8; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                // 체스판 벗어나면 예외 처리
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                // 이미 다녀간 곳이면 예외 처리
                if (dist[nx][ny] != -1) continue;

                Q.add(nx);
                Q.add(ny);
                dist[nx][ny] = dist[x][y] + 1;
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
