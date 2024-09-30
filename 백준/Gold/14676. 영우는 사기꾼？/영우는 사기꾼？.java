import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int N, M, K;
    static ArrayList<Integer>[] adj;
    static int[] cnt, indeg;
    static Set<Integer>[] prev_list;

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        prev_list = new Set[N + 1];
        for (int i = 1; i <= N; i++) prev_list[i] = new HashSet<>();
        cnt = new int[N + 1];
        indeg = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adj[x].add(y);
            indeg[y]++;
        }
    }

    private static void pro() throws IOException {
        String s = "King-God-Emperor";

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int game = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (!checkPossible(game, num)) {
                s = "Lier!";
                break;
            }
        }

        bw.write(s + " ");
        bw.newLine();
    }

    private static boolean checkPossible(int game, int num) {
        boolean result = false;

        switch (game) {
            case 1:
                if (prev_list[num].size() == indeg[num]) {
                    cnt[num]++;

                    if (cnt[num] == 1)
                        for (int y : adj[num]) prev_list[y].add(num);

                    result = true;
                }
                break;
            case 2:
                if (cnt[num] > 0) {
                    cnt[num]--;

                    if (cnt[num] == 0)
                        for (int y : adj[num]) prev_list[y].remove(num);

                    result = true;
                }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
