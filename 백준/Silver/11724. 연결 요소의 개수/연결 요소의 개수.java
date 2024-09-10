import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int V, E, ans;
    static int map[][];
    static boolean visit[];

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        map = new int[V + 1][V + 1];
        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 1;
            map[y][x] = 1;
        }

        visit = new boolean[V + 1];
    }

    private static void pro() throws IOException {
        for (int i = 1; i <= V; i++) {
            if (visit[i]) continue;
            bfs(i);
            ans++;
        }

        bw.write(ans + " ");

    }

    private static void dfs(int x) {
        visit[x] = true;

        for (int y = 1; y <= V; y++) {
            if (map[x][y] == 0) continue;
            if (visit[y]) continue;

            dfs(y);
        }
    }

    private static void bfs(int x) {
        Queue<Integer> que = new LinkedList<>();

        que.add(x);
        visit[x] = true;

        while (!que.isEmpty()) {
            x = que.poll();

            for (int y = 1; y <= V; y++) {
                if (map[x][y] == 0) continue;
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
