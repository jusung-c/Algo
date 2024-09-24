import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int N;
    static ArrayList<Integer>[] adj;
    static int[] dist;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adj[x].add(y);
            adj[y].add(x);
        }

        dist = new int[N + 1];
        Arrays.fill(dist, -1);
    }

    private static void pro() throws IOException {
        bfs(1);

        int sum = 0;

        for (int i = 1; i <= N; i++) {
            if (adj[i].size() != 1) continue;
            sum += dist[i];
        }

        bw.write(sum % 2 == 0 ? "No" : "Yes");
    }

    private static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        dist[start] = 0;

        while (!que.isEmpty()) {
            int x = que.poll();

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
