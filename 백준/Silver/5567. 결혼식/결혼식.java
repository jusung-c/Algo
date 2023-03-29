import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int[] dist;
    static ArrayList<Integer>[] adj;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        dist = new int[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }
    }

    private static void pro() throws IOException {
        bfs(1);

        int ans = 0;
        for (int i = 2; i <= N; i++) {
            if (dist[i] > 0 && dist[i] <= 2) {
                ans++;
            }
        }

        bw.write(ans + " ");
    }

    private static void bfs(int a) {
        for (int i = 1; i <= N; i++) {
            dist[i] = -1;
        }

        Queue<Integer> Q = new LinkedList<>();

        Q.add(a);
        dist[a] = 0;

        while (!Q.isEmpty()) {
            int x = Q.poll();

            for (int i = 0; i < adj[x].size(); i++) {
                int nx = adj[x].get(i);

                if (dist[nx] != -1) continue;

                Q.add(nx);
                dist[nx] = dist[x] + 1;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
