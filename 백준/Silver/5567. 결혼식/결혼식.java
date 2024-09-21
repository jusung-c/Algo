import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] dist;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        dist = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dist[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adj[x].add(y);
            adj[y].add(x);
        }
    }

    private static void pro() throws IOException {
        bfs(1);

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] > 0 && dist[i] <= 2) sum++;
        }

        bw.write(sum + " ");
    }

    private static void bfs(int x) {
        Queue<Integer> que = new LinkedList<>();
        que.add(x);
        dist[x] = 0;

        while (!que.isEmpty()) {
            x = que.poll();

            for (int y : adj[x]) {
                if (dist[y] != -1) continue;

                que.add(y);
                dist[y] = dist[x] + 1;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
