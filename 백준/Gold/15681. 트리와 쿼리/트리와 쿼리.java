import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int N, R, Q;
    static ArrayList<Integer>[] adj;
    static int[] subCnt;
    static boolean[] visit;

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        subCnt = new int[N + 1];

        visit = new boolean[N + 1];

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj[u].add(v);
            adj[v].add(u);
        }

    }

    private static void pro() throws IOException {
        visit[R] = true;
        countSub(R);

//        for (int i = 1; i <= N; i++) {
//            bw.write(subCnt[i] + " ");
//        }
//        bw.newLine();

        for (int i = 1; i <= Q; i++) {
            int query = Integer.parseInt(br.readLine());

            bw.write(subCnt[query] + " ");
            bw.newLine();
        }
    }

//    private static void countSub(int root) {
//        Queue<Integer> que = new LinkedList<>();
//        que.add(root);
//        subCnt[root] = 1;
//
//        while (!que.isEmpty()) {
//            int x = que.poll();
//
//            for (int y : adj[x]) {
//                if (subCnt[y] != -1) continue;
//
//                que.add(y);
//                subCnt[y] = 1;
//                subCnt[x] += subCnt[y];
//            }
//        }
//
//    }

    private static void countSub(int x) {
        subCnt[x] += 1;

        for (int y : adj[x]) {
            if (visit[y]) continue;

//            System.out.println("y = " + y);
            visit[y] = true;
            countSub(y);
            subCnt[x] += subCnt[y];
            visit[y] = false;
        }
    }


    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
