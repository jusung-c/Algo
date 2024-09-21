import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int N, K;
    static int[] dist;

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[100001];
        for (int i = 0; i < 100001; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
    }

    private static void pro() throws IOException {
        bfs(N);

        bw.write(dist[K] + " ");
    }

    private static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        dist[start] = 0;

        while (!que.isEmpty()) {
            int p = que.poll();

            for (int i = 0; i < 3; i++) {
                int np = -1;

                switch (i) {
                    case 0:
                        np = p + 1;
                        break;
                    case 1:
                        np = p - 1;
                        break;
                    case 2:
                        np = p * 2;
                        break;
                }

                if (np < 0 || np > 100000) continue;
                if (dist[np] <= dist[p] + 1) continue;

                dist[np] = dist[p] + 1;
                que.add(np);
            }

        }
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
