import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] Limit;
    static boolean[][][] visit;
    static boolean[] possible;

    static class State {
        int X[];

        public State(int[] x) {
            X = new int[3];

            for (int i = 0; i < 3; i++) {
                X[i] = x[i];
            }
        }

        // 물 붓기
        public State move(int from, int to, int[] Limit) {
            int nX[] = new int[] {X[0], X[1], X[2]};

            if (X[from] + X[to] >= Limit[to]) {
                nX[from] = X[from] + X[to] - Limit[to];
                nX[to] = Limit[to];
            } else {
                nX[from] = 0;
                nX[to] = X[to] + X[from];
            }

            return new State(nX);
        }
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        Limit = new int[3];

        for (int i = 0; i < 3; i++) {
            Limit[i] = Integer.parseInt(st.nextToken());
        }

        visit = new boolean[202][202][202];
        possible = new boolean[202];

    }

    private static void pro() throws IOException {
        bfs(0, 0, Limit[2]);

        for (int i = 0; i <= Limit[2]; i++) {
            if (possible[i]) bw.write(i + " ");
        }
    }

    private static void bfs(int x1, int x2, int x3) {
        Queue<State> Q = new LinkedList<>();

        Q.add(new State(new int[]{x1, x2, x3}));
        visit[x1][x2][x3] = true;

        while (!Q.isEmpty()) {
            State s = Q.poll();

            if (s.X[0] == 0) possible[s.X[2]] = true;

            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (from == to) continue;

                    State ns = s.move(from, to, Limit);

                    if (visit[ns.X[0]][ns.X[1]][ns.X[2]]) continue;

                    visit[ns.X[0]][ns.X[1]][ns.X[2]] = true;
                    Q.add(ns);
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
