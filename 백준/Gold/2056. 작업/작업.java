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
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        indeg = new int[N + 1];
        time = new int[N + 1];
        delay = new int[N + 1];

        for (int task = 1; task <= N; task++) {
            st = new StringTokenizer(br.readLine());
            delay[task] = Integer.parseInt(st.nextToken());

            int size = Integer.parseInt(st.nextToken());
            for (int j = 0; j < size; j++) {
                int prev = Integer.parseInt(st.nextToken());

                adj[prev].add(task);
                indeg[task]++;
            }
        }
    }

    private static void pro() throws IOException {
        tpSort();

        int answer = Arrays.stream(time).max().getAsInt();
        bw.write(answer + " ");
    }

    private static void tpSort() {
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
