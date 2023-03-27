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
    static int[] ans;
    static ArrayList<Integer>[] friend;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        friend = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            friend[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friend[a].add(b);
            friend[b].add(a);
        }
    }

    private static void pro() throws IOException {

        int r_value = bfs(1);
        int r_idx = 1;

        for (int i = 2; i <= N; i++) {
            int v = bfs(i);
            if (r_value > v) {
                r_value = v;
                r_idx = i;
            }
        }

        bw.write(r_idx + " ");

    }

    private static int bfs(int a) {
        for (int i = 1; i <= N; i++) {
            dist[i] = -1;
        }

        Queue<Integer> Q = new LinkedList<>();
        Q.add(a);
        dist[a] = 0;

        int ans = 0;

        while (!Q.isEmpty()) {
            int x = Q.poll();
            ans += dist[x];

            for (int i = 0; i < friend[x].size(); i++) {
                int nx = friend[x].get(i);

                if (dist[nx] != -1) continue;
                Q.add(nx);
                dist[nx] = dist[x] + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
