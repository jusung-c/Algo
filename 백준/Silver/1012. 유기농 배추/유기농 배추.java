import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int T, M, N, K, answer;
    static int[][] map;
    static boolean[][] visit;
    static int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void init() throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            answer = 0;

            map = new int[M][N];
            visit = new boolean[M][N];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int m = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());

                map[m][n] = 1;
            }

            pro();

            bw.write(answer + " ");
        }

    }

    private static void pro() throws IOException {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && map[i][j] == 1) {
                    dfs(i, j);
                    answer++;
//                    bw.write("("+i+", " + j + ")");
//                    bw.newLine();
                }
            }
        }

    }

    private static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dir[d][0];
            int ny = y + dir[d][1];

            if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;

            if (visit[nx][ny]) continue;

            if (map[nx][ny] == 0) continue;

            dfs(nx, ny);
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        bw.close();
    }
}
