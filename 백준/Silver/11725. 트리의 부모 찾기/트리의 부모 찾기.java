import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int N;
    static boolean[] visit;
    static int[] answer;
    static ArrayList<Integer>[] adj;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        visit = new boolean[N + 1];
        answer = new int[N + 1];

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adj[x].add(y);
            adj[y].add(x);
        }

        bfs(1);
    }

    private static void bfs(int i) {
        Queue<Integer> que = new LinkedList<>();
        que.add(i);
        visit[i] = true;

        while (!que.isEmpty()) {
            i = que.poll();

            for (int y : adj[i]) {
                if (visit[y]) continue;

                answer[y] = i;
                visit[y] = true;
                que.add(y);
            }
        }
    }

    private static void pro() throws IOException {
        for (int i = 2; i <= N; i++) {
            bw.write(answer[i] + " ");
            bw.newLine();
        }

    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
