import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, T;
    static int[] map;
    static boolean[] visit;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            map = new int[N + 1];
            visit = new boolean[N + 1];

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= N; i++) {
                map[i] = Integer.parseInt(st.nextToken());
                visit[i] = false;
            }

            int ans = 0;
            for (int i = 1; i <= N; i++) {
                if (visit[i]) continue;
                dfs(i);
                ans++;
            }

            bw.write(ans + "\n");
        }

    }

    private static void dfs(int a) {
        visit[a] = true;

        int nx = map[a];
        if (!visit[nx]) {
            dfs(nx);
        }

    }

    private static void pro() throws IOException {


    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
