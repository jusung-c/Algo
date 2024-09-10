import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int N, E, S;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adj[x].add(y);
            adj[y].add(x);
        }

    }

    private static void pro() throws IOException {
        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }

        visit = new boolean[N + 1];
        dfs(S);

        bw.newLine();
        
        visit = new boolean[N + 1];
        bfs(S);

    }

    private static void dfs(int x) throws IOException {
        visit[x] = true;
        bw.write(x + " ");

        for (int y : adj[x]) {
            if (visit[y]) continue;
            dfs(y);
        }
    }

    private static void bfs(int x) throws IOException {
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

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
