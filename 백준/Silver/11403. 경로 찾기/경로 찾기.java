import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[][] map, ans;
    static boolean[] visit;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        ans = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        // map 저장
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void pro() throws IOException {
        for (int x = 1; x <= N; x++) {
            bfs(x);
        }

        // ans 출력
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                bw.write(ans[i][j] + " ");
            }
            bw.write("\n");
        }
    }

    private static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            visit[i] = false;
        }

        que.add(start);
        visit[start] = false;

        while (!que.isEmpty()) {
            int x = que.poll();

            for (int y = 1; y <= N; y++) {
                if (map[x][y] == 0) continue;
                if (visit[y]) continue;

                que.add(y);
                visit[y] = true;
                ans[start][y] = 1;
            }
        }

//        for (int i = 1; i <= N; i++) {
//            if (visit[i]) ans[x][i] = 1;
//            else ans[x][i] = 0;
//        }

    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
