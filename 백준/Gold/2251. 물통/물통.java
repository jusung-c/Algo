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

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Limit = new int[3];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 3; i++) {
            Limit[i] = Integer.parseInt(st.nextToken());
        }

        possible = new boolean[205];
        visit = new boolean[205][205][205];
    }

    static class State {
        int[] X;

        State(int[] _X) {
            X = new int[3];
            for (int i = 0; i < 3; i++) X[i] = _X[i];
        }

        State move(int from, int to, int[] Limit) {
            // from -> to 물을 붓는다.
            int[] nX = new int[]{X[0], X[1], X[2]};

            if (X[from] + X[to] <= Limit[to]){  // 만약 from 을 전부 부을 수 있다면
                nX[to] = X[from] + X[to];
                nX[from] = 0;
            }else{  // from 의 일부만 옮길 수 있는 경우
                nX[from] -= Limit[to] - X[to];
                nX[to] = Limit[to];
            }

            return new State(nX);
        }
    }


    static void pro() throws IOException {
        // 초기 상태에서 탐색 시작
        bfs(0, 0, Limit[2]);

        // 정답 갱신
        for (int i = 0; i <= Limit[2]; i++) {
            if (possible[i]) bw.write(i + " ");
        }

    }

    static void bfs(int x1, int x2, int x3) {
        Queue<State> Q = new LinkedList<>();
        visit[x1][x2][x3] = true;
        Q.add(new State(new int[]{x1, x2, x3}));

        // BFS 탐색 시작
        while (!Q.isEmpty()) {
            State s = Q.poll();

            // A 물통이 비어있을 경우 C의 상태 기록!
            if (s.X[0] == 0) {
                possible[s.X[2]] = true;
            }

            // 가능한 6가지의 경우 모두 물 부어보기!!
            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    // 같은 물통끼리는 부을 수 없으므로 제외!!
                    if(from == to) continue;

                    // 물 부워서 바뀐 상태!
                    State ns = s.move(from, to, Limit);

                    // 방문했던 상태면 제외!!
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
