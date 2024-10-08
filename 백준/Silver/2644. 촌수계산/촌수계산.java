import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N,M;
    static int start,end;
    static int[] dist;
    static ArrayList<Integer>[] adj;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        dist = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dist[i] = -1;
        }

        st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        adj = new ArrayList[N * 2 + 1];

        for (int i = 1; i <= N * 2; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            adj[parent].add(child);
            adj[child].add(parent);
        }
    }

    private static void pro() throws IOException {
        bfs(start);

        bw.write(dist[end] + " ");
    }

    private static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();

        que.add(start);
        dist[start] = 0;

        while (!que.isEmpty()) {
            int x = que.poll();

            for (int i = 0; i < adj[x].size(); i++) {
                int nx = adj[x].get(i);

                if (dist[nx] != -1) continue;

                que.add(adj[x].get(i));
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
