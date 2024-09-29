import java.io.*;
import java.util.*;

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

        indeg = new int[N + 1];
        answer = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adj[x].add(y);
            indeg[y]++;
        }
    }

    private static void pro() throws IOException {
        topologySort();

        System.out.println(answer + " ");
    }

    private static void topologySort() {
        Queue<Integer> que = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) que.add(i);
        }

        while (!que.isEmpty()) {
            int x = que.poll();
            answer.append(x).append(" ");

            for (int y : adj[x]) {
                indeg[y]--;

                if (indeg[y] == 0) que.add(y);
            }
        }


    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
