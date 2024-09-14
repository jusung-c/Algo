import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int N;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n == 1) adj[i].add(j);
            }
        }
    }

    private static void pro() throws IOException {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                visit = new boolean[N + 1];
                int result = isExistPath(i, j) ? 1 : 0;
                bw.write(result + " ");
            }
            bw.newLine();
        }
    }

    private static boolean isExistPath(int i, int j) {
        Queue<Integer> que = new LinkedList<>();
        que.add(i);
        visit[i] = true;

        while (!que.isEmpty()) {
            i = que.poll();

            for (int y : adj[i]) {
                if (y == j) return true;
                if (visit[y]) continue;

                que.add(y);
                visit[y] = true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
