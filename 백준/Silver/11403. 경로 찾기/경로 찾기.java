import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int N;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static int[][] ans;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        ans = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n == 1) adj[i].add(j);
            }
        }
    }

    private static void pro() throws IOException {
        for (int i = 1; i <= N; i++) {
            visit = new boolean[N + 1];
            bfs(i);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                bw.write(ans[i][j] + " ");
            }
            bw.newLine();
        }
    }

    private static void bfs(int i) {
        Queue<Integer> que = new LinkedList<>();
        que.add(i);

        while (!que.isEmpty()) {
            int x = que.poll();

            for (int y : adj[x]) {
                if (visit[y]) continue;

                que.add(y);
                visit[y] = true;
                ans[i][y] = 1;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
