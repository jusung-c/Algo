import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] Limit;
    static boolean[] possible;
    static boolean[][][] visit;

    static class State {
        int[] X = new int[3];

        // 생성자
        public State(int[] newX) {
            for (int i = 0; i < 3; i++) {
                X[i] = newX[i];
            }
        }

        // 물 붓기
        State move(int from, int to, int[] Limit) {
            // from -> to 물 붓기
            int[] nX = new int[]{X[0], X[1], X[2]};

            // to 물통이 꽉차는 경우
            if (X[from] + X[to] >= Limit[to]) {
                nX[to] = Limit[to];
                nX[from] = X[from] - (Limit[to] - X[to]);
            } else {
                nX[from] = 0;
                nX[to] = X[from] + X[to];
            }

            return new State(nX);
        }
    }


    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");

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
        Queue<State> q = new LinkedList<>();

        visit[x1][x2][x3] = true;
        q.add(new State(new int[]{x1, x2, x3}));

        while (!q.isEmpty()) {
            State s = q.poll();

            // A 물통이 비어있을 경우 C 상태 정답 기록
            if (s.X[0] == 0) possible[s.X[2]] = true;

            // 가능한 6가지의 경우 모두 물 부어보기!
            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    // 같은 물통끼리는 부을 수 없으니까 제외
                    if (from == to) continue;

                    // 물 부은 결과
                    State ns = s.move(from, to, Limit);

                    // 이미 방문했던 상태면 제외!
                    if (visit[ns.X[0]][ns.X[1]][ns.X[2]]) {
                        continue;
                    }

                    visit[ns.X[0]][ns.X[1]][ns.X[2]] = true;
                    q.add(ns);
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
