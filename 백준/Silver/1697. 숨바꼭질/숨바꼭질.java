import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int start, end;
    static int MAX = 100001;
    static int[] dist = new int[MAX];

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
    }

    private static void pro() throws IOException {
//        if (start == end) {
//            bw.write(0 + " ");
//            return;
//        } else {
//            bfs();
//        }
        bfs();

        bw.write(dist[end] - 1 + " ");

    }

    private static void bfs() {
        Queue<Integer> Q = new LinkedList<>();

        Q.add(start);
        dist[start] = 1;

        while (!Q.isEmpty()) {
            int n = Q.poll();

            for (int next = 0; next < 3; next++) {
                int nn;

                if (next == 0) {
                    nn = n + 1;
                } else if (next == 1) {
                    nn = n - 1;
                } else {
                    nn = n * 2;
                }

                if (nn >= 0 && nn < MAX && dist[nn] == 0) {
                    Q.add(nn);
                    dist[nn] = dist[n] + 1;
                }

            }
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
