import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] indeg;
    static StringBuilder answer;

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        answer = new StringBuilder();
        indeg = new int[N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int next = Integer.parseInt(st.nextToken());

                indeg[next]++;
                adj[prev].add(next);
                prev = next;
            }
        }
    }

    private static void pro() throws IOException {
        ;

        bw.write(tpSort() ? answer + " " : "0");
    }

    private static boolean tpSort() {
        Queue<Integer> que = new LinkedList<>();
        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) que.add(i);
        }

        while (!que.isEmpty()) {
            int x = que.poll();
            cnt++;
            answer.append(x).append("\n");

            for (int y : adj[x]) {
                indeg[y]--;

                if (indeg[y] == 0) que.add(y);
            }
        }

        return cnt == N;
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
