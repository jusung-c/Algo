import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int cost[][];
    static boolean visit[];
    static int ans = Integer.MAX_VALUE;


    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cost = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void pro() throws IOException {
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                visit[j] = false;
//            }
//            visit[i] = true;
//            dfs(i, i, 1, 0);
//        }

        visit[1] = true;
        dfs(1, 1, 1, 0);

        bw.write(ans + " ");
    }

    private static void dfs(int start, int now, int cnt, int val) {

        if (now == start && cnt == N + 1) {
            ans = Math.min(ans, val);
        }


        for (int i = 1; i <= N; i++) {

            // 길이 있는 경우 탐색
            if (cost[now][i] > 0) {
                // 시작점으로 돌아갈 일만 남았을 경우
                if (i == start && cnt == N) {
                    val += cost[now][start];
                    dfs(start, start, cnt + 1, val);
                } else if (!visit[i]) {
                    val += cost[now][i];
                    visit[i] = true;

                    dfs(start, i, cnt + 1, val);

                    val -= cost[now][i];
                    visit[i] = false;
                }

            }

        }

    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
