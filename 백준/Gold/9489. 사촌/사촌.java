import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ;
    static StringTokenizer st;
    static int N, K;
    public static void init() throws IOException {
        while (true) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            if (N == 0 && K == 0) break;

            input = new int[N + 1];
            parent = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }

            pro();

        }
    }

    static int[] input, parent;

    private static void pro() throws IOException {
        // 각 노드의 부모 노드 인덱스를 계산하자. 루트 노드가 1번 노드임을 생각해야 한다.
        // 편의상 0번 정점의 부모를 -1로 하자
        parent[0] = -1;
        parent[1] = 0;

        // 자식 정점들을 찾을 노드의 인덱스
        int last = 1;
        for (int i = 2; i <= N; i++, last++) {

            // i번부터 연속한 수를 가진 정점을 모두 last의 자식으로 묶는다.
            for (; i <= N; i++) {
                parent[i] = last;
//                System.out.println(i + "번째 노드인 " + input[i] +"의 부모는 " + input[parent[i]] + "입니다.");

                // 연속한 수가 끝나면 다음으로
                if (i < N && input[i] + 1 != input[i + 1]) {
                    break;
                }
            }
        }

        // 수가 K인 정점의 인덱스 찾기
        int kIdx = 0;
        for (int i = 1; i <= N; i++) {
            if (input[i] == K) kIdx = i;
        }

        // 사촌: 부모의 부모는 동일하나 부모는 다른 정점의 개수
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (parent[parent[i]] == parent[parent[kIdx]] &&
                    parent[i] != parent[kIdx]) {
                ans++;
            }
        }

        bw.write(ans + " ");
        bw.newLine();
    }

    public static void main(String[] args) throws Exception {
        init();

        bw.close();
    }
}
