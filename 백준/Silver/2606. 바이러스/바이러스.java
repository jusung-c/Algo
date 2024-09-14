import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int N, K, cnt;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        visit = new boolean[N + 1];
        cnt = 0;

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adj[x].add(y);
            adj[y].add(x);
        }

        dfs(1);

        bw.write(cnt - 1 + " ");
    }

    private static void dfs(int x) {
        visit[x] = true;
        cnt++;

        for (int y : adj[x]) {
            if (visit[y]) continue;
            dfs(y);
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
