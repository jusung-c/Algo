import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] indeg;
    static int[][] answer;
    static Set<Integer> basic;


    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        answer = new int[N + 1][N + 1];
        indeg = new int[N + 1];
        basic = new HashSet<>();

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int block = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());

            adj[block].add(num);
            indeg[num]++;
            answer[num][block] = cnt;
        }
    }

    private static void pro() throws IOException {

        tpSort();

        for (int i = 1; i <= N; i++) {
            if (basic.contains(i))
                bw.write(i + " " + answer[N][i] + "\n");
        }
    }

    private static void tpSort() throws IOException {
        Queue<Integer> que = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                que.add(i);
                basic.add(i);
                answer[i][i] = 1;
            }
        }

        while (!que.isEmpty()) {
            int x = que.poll();

            for (int y : adj[x]) {
                indeg[y]--;

                for (int i = 1; i <= N; i++) {
                    if (!basic.contains(x) && answer[x][i] > 0) {
                        answer[y][i] += answer[x][i] * answer[y][x];
                    }
                }

                if (!basic.contains(x)) answer[y][x] = 0;
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
