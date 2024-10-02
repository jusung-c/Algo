import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int T, N, K, W;
    static int[] indeg, delay, time;
    static ArrayList<Integer>[] adj;

    public static void init() throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            indeg = new int[N + 1];
            delay = new int[N + 1];
            time = new int[N + 1];

            adj = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) delay[i] = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                adj[x].add(y);
                indeg[y]++;
            }

            W = Integer.parseInt(br.readLine());

            pro();
        }

    }

    private static void pro() throws IOException {
        tpSort();

        bw.write(time[W] + " ");
        bw.newLine();
    }

    private static void tpSort() {
        Queue<Integer> que = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                que.add(i);
                time[i] += delay[i];
            }
        }

        while (!que.isEmpty()) {
            int x = que.poll();

            for (int y : adj[x]) {
                indeg[y]--;

                time[y] = Math.max(time[y], time[x] + delay[y]);

                if (indeg[y] == 0) {
                    que.add(y);
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {
        init();

        bw.close();
    }
}
