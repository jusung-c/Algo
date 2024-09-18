import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int[] maxList;
    static boolean[][][] visit;
    static boolean[] answer;
    static class State {
        int[] buckets;

        public State(int a, int b, int c) {
            this.buckets = new int[3];
            this.buckets[0] = a;
            this.buckets[1] = b;
            this.buckets[2] = c;
        }

        public State(int[] buckets) {
            this.buckets = buckets;
        }

        private State pour(int from, int to) {
            int[] newBuckets = new int[]{buckets[0], buckets[1], buckets[2]};

            if (buckets[from] + buckets[to] <= maxList[to]) {
                newBuckets[from] = 0;
                newBuckets[to] = buckets[from] + buckets[to];
            } else {
                newBuckets[from] = buckets[from] + buckets[to] - maxList[to];
                newBuckets[to] = maxList[to];
            }

            return new State(newBuckets);
        }
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        maxList = new int[3];
        for (int i = 0; i < 3; i++) {
            maxList[i] = Integer.parseInt(st.nextToken());
        }

        visit = new boolean[201][201][201];
        answer = new boolean[201];
    }

    private static void bfs(int a, int b, int c) {
        Queue<State> que = new LinkedList<>();
        que.add(new State(a, b, c));

        visit[a][b][c] = true;

        while (!que.isEmpty()) {
            State s = que.poll();

            // A 물통이 비어있을 경우 C의 상태 기록!
            if (s.buckets[0] == 0) answer[s.buckets[2]] = true;

            // 가능한 6가지의 경우 모두 탐색
            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    // 같은 물통끼리는 제외
                    if (from == to) continue;

                    // 물 부어보기
                    State ns = s.pour(from, to);

                    // 이미 방문했던 상태면 제외
                    if (visit[ns.buckets[0]][ns.buckets[1]][ns.buckets[2]]) continue;

                    que.add(ns);
                    visit[ns.buckets[0]][ns.buckets[1]][ns.buckets[2]] = true;
                }
            }
        }
    }

    private static void dfs(int a, int b, int c) {
        visit[a][b][c] = true;

        // A 물통이 비어있을 경우 C의 상태 기록!
        if (a == 0) answer[c] = true;

        State s = new State(a, b, c);

        // 가능한 6가지의 경우 모두 탐색
        for (int from = 0; from < 3; from++) {
            for (int to = 0; to < 3; to++) {
                // 같은 물통끼리는 제외
                if (from == to) continue;

                // 물 부어보기
                State ns = s.pour(from, to);

                // 이미 방문했던 상태면 제외
                if (visit[ns.buckets[0]][ns.buckets[1]][ns.buckets[2]]) continue;

                visit[ns.buckets[0]][ns.buckets[1]][ns.buckets[2]] = true;
                dfs(ns.buckets[0], ns.buckets[1], ns.buckets[2]);
            }
        }
    }


    private static void pro() throws IOException {
//        bfs(0, 0, maxList[2]);
        dfs(0, 0, maxList[2]);

        for (int i = 0; i <= maxList[2]; i++) {
            if (answer[i]) bw.write(i + " ");
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
