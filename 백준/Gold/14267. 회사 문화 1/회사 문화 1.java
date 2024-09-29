import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] score;

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int parent = Integer.parseInt(st.nextToken());

            if (parent == -1) continue;

            adj[parent].add(i);
        }

        score = new int[N + 1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            score[n] += s;
        }
    }

    private static void pro() throws IOException {
        bfs(1);

        for (int i = 1; i <= N; i++) {
            bw.write(score[i] + " ");
        }
    }

    private static void bfs(int x) {
        Queue<Integer> que = new LinkedList<>();
        que.add(x);
        score[x] += score[x - 1];

        while (!que.isEmpty()) {
            x = que.poll();

            for (int y : adj[x]) {
                score[y] += score[x];
                que.add(y);
            }
        }

    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
