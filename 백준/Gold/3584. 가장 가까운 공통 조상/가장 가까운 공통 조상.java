import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T, N;
    static ArrayList<Integer>[] tree;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            // 트리 초기화
            tree = new ArrayList[N + 1];
            parent = new int[N + 1];
            visited = new boolean[N + 1];

            for (int i = 1; i <= N; i++) {
                tree[i] = new ArrayList<>();
            }

            // 간선 정보 입력
            for (int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                parent[v] = u;  // 자식 -> 부모 관계 저장
            }

            // 두 노드 입력
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            // 공통 조상 찾기
            System.out.println(findLCA(node1, node2));
        }
    }

    // 공통 조상을 찾는 함수
    static int findLCA(int a, int b) {
        Arrays.fill(visited, false);

        // a에서 루트까지 경로 따라가며 방문 처리
        while (a != 0) {
            visited[a] = true;
            a = parent[a];
        }

        // b에서 루트까지 올라가며, 방문된 노드를 찾으면 그게 공통 조상
        while (b != 0) {
            if (visited[b]) {
                return b;
            }
            b = parent[b];
        }

        return -1;  // 예외 처리 (이론적으로는 여기에 도달하지 않음)
    }
}
