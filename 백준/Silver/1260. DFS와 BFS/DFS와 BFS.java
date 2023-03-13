import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, V;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 양방향 그래프이므로
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    // x를 갈 수 있다는 걸 알고 방문한 상태
    static void dfs(int x) throws IOException {
        // 방문 후 출력
        visit[x] = true;
        bw.write(x + " ");

        for (int y : adj[x]) {
            if (visit[y]) continue;
            dfs(y);
        }
    }

    // start에서 시작해서 갈 수 있는 정점들을 모두 탐색
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
        // 모든 정점마다 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }

        visit = new boolean[N + 1];

        dfs(V);

        bw.write("\n");

        // BFS를 위한 visit 배열 초기화
        for (int i = 1; i <= N; i++) {
            visit[i] = false;
        }

        bfs(V);
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
