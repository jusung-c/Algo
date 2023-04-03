import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[][] w;
    static boolean[] visited;
    static int ans = Integer.MAX_VALUE;


    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        w = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void pro() throws IOException {
        // 1번 도시부터 시작
        visited[1] = true;
        dfs(1, 1, 1, 0);

        bw.write(ans + " ");

    }

    private static void dfs(int start, int now, int cnt, int cost) {

        // 모든 도시를 방문 후 다시 시작점으로 돌아왔을 경우
        if (now == start && cost > 0) {
            // 이번 여행 루트의 cost를 비교해서 갱신
            ans = Math.min(ans, cost);
        }

        // dfs 시작
        for (int i = 1; i <= N; i++) {

            // 현재 도시 now에서 i 도시로 가는 길이 있는 경우
            if (w[now][i] > 0) {

                // 방문할 i 도시가 시작한 도시이면서 모든 도시를 방문해서 마지막으로 가는 경우
                if (i == start && cnt == N) {
                    // 비용에 현재 도시에서 시작점까지 가는 비용을 더해줌
                    cost += w[now][start];
                    dfs(start, start, cnt + 1, cost);


                    // 방문하지 않은 도시인 경우
                } else if (!visited[i]) {
                    visited[i] = true;
                    cost += w[now][i];

                    dfs(start, i, cnt + 1, cost);

                    cost -= w[now][i];
                    visited[i] = false;
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
