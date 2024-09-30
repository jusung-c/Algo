import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ;
    static StringTokenizer st;
    static int T, K, M, P, answer;
    static ArrayList<Integer>[] adj;
    static int[] indeg, order, maxCnt;

    public static void init() throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());

            adj = new ArrayList[M + 1];
            for (int i = 1; i <= M; i++) adj[i] = new ArrayList<>();

            indeg = new int[M + 1];
            order = new int[M + 1];
            maxCnt = new int[M + 1];

            for (int i = 1; i <= P; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                adj[A].add(B);
                indeg[B]++;
            }

            answer = 0;
            pro();
        }

    }

    private static void pro() throws IOException {
        tpSort();
//        for (int i = 1; i <= M; i++) {
//            System.out.println("order[" + i + "] = " + order[i]);
//        }
        bw.write(K + " " + answer + " ");
        bw.newLine();
    }

    private static void tpSort() {
        Queue<Integer> que = new LinkedList<>();

        // 시작하는 정점(후보) 넣기
        for (int i = 1; i <= M; i++) {
            if (indeg[i] == 0) {
                que.add(i);
                order[i] = maxCnt[i] = 1;
            }
        }

        // 위상정렬 시작
        while (!que.isEmpty()) {
            // 후보에서 하나씩 하나씩 빼기
            int x = que.poll();

            // x로 들어오는 동일한 최대 순서의 간선이 2개 이상이면 order[x] + 1로 설정한다.
            if (maxCnt[x] >= 2) order[x]++;

            // 최대인 값을 출력하면 되므로 최댓값 갱신
            answer = Math.max(answer, order[x]);

            for (int y : adj[x]) {
                // 그래프 지우기
                indeg[y]--;

                // 새로운 후보 추가
                if (indeg[y] == 0) que.add(y);

                // y로 들어오는 동일한 순서의 간선이 추가된 경우
                if (order[y] == order[x]) maxCnt[y]++;    // 동일한 순서이므로 개수를 증가시킨다.

                // 동일하지 않은 순서의 간선, 즉 더 큰 수의 간선이 들어올 경우 큰값으로 갱신한다.
                else if (order[y] != order[x] && order[y] < order[x]) {
                    order[y] = order[x];        // 큰 값으로 설정
                    maxCnt[y] = 1;              // 큰 값의 개수를 초기화
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        bw.close();
    }
}
