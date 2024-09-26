import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int N, M, answer;
    static int[][] map;
    static boolean[] visit;

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            map[u][v] = dist;
            map[v][u] = dist;
        }

//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                bw.write(map[i][j] + " ");
//            }
//            bw.newLine();
//        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            answer = Integer.MAX_VALUE;
            findMinDist(a, b, 0);

            bw.write(answer + " ");
            bw.newLine();
        }
    }

    private static void findMinDist(int x, int end, int dist) throws IOException {
        if (x == end) {
            answer = Math.min(answer, dist);
            return;
        }

        for (int y = 1; y <= N; y++) {
            if (map[x][y] == 0) continue;
            if (visit[y]) continue;

            dist += map[x][y];
            visit[y] = true;

            findMinDist(y, end, dist);

            dist -= map[x][y];
            visit[y] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        bw.close();
    }
}
