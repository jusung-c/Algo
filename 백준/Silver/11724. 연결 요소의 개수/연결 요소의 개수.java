import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int V, E;
    static int[][] map;
    static boolean[] visit;
    static ArrayList<Integer>[] arr;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        map = new int[V + 1][V + 1];
        visit = new boolean[V + 1];
        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 1;
            map[y][x] = 1;
        }
    }

    private static void pro() throws IOException {
        int cnt = 0;
        for (int i = 1; i <= V; i++) {
            if (visit[i]) continue;
            dfs(i);
            cnt++;
        }

        bw.write(cnt + " ");

    }

    private static void dfs(int a) {
        visit[a] = true;

        for (int i = 1; i <= V; i++) {
            if (visit[i]) continue;
            if (map[a][i] == 1) dfs(i);
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
