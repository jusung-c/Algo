import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int N;
    static int[] indeg, time, delay;
    static ArrayList<Integer>[] adj;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        indeg = new int[N + 1];
        time = new int[N + 1];
        delay = new int[N + 1];

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            delay[i] = Integer.parseInt(st.nextToken());

            while (true) {
                int num = Integer.parseInt(st.nextToken());
                if (num == -1) break;

                adj[num].add(i);
                indeg[i]++;
            }
        }

    }

    private static void pro() throws IOException {
        tpSort();

        for (int i = 1; i <= N; i++) {
            bw.write(time[i] + " ");
            bw.newLine();
        }
    }

    private static void tpSort() throws IOException {
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
