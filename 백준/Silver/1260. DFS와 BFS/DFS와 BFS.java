import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M, V;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adj[x].add(y);
            adj[y].add(x);
        }

    }

    static void dfs(int x) throws IOException {
        visit[x] = true;
        bw.write(x + " ");

        for (int y : adj[x]) {
            if (visit[y]) continue;
            dfs(y);
        }
    }
    
    static void bfs(int x) throws IOException {
        Queue<Integer> que = new LinkedList<>();

        que.add(x);
        visit[x] = true;

        while (!que.isEmpty()) {
            x = que.poll();
            bw.write(x + " ");

            for (int y : adj[x]) {
                if (visit[y]) continue;

                que.add(y);
                visit[y] = true;
            }
        }
    }

    private static void pro() throws IOException {
        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }

        visit = new boolean[N + 1];
        dfs(V);

        bw.newLine();

        visit = new boolean[N + 1];
        bfs(V);

    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
