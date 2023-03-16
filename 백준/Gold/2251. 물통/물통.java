import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class State {
    int[] X;

    State(int[] XX) {
        X = new int[3];
        for (int i = 0; i < 3; i++) X[i] = XX[i];
    }

    State move(int from, int to, int[] Limit) {
        State nX = new State(X);

        // 물통이 꽉찬 경우
        if (X[from] + X[to] >= Limit[to]) {
            nX.X[to] = Limit[to];
            nX.X[from] = nX.X[from] - (Limit[to] - X[to]);
        } else {
            nX.X[from] = 0;
            nX.X[to] = X[from] + X[to];
        }

        return nX;
    }
}

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] Limit;
    static boolean[][][] visit;
    static boolean[] possible;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Limit = new int[3];
        st = new StringTokenizer(br.readLine(), " ");
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

    private static void bfs(int A, int B, int C) {
        Queue<State> Q = new LinkedList<>();
        Q.add(new State(new int[]{A, B, C}));
        visit[A][B][C] = true;

        while (!Q.isEmpty()) {
            State s = Q.poll();
            if (s.X[0] == 0) possible[s.X[2]] = true;

            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if(from == to) continue;

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
