import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int T, N, answer, A, B;
    static ArrayList<Integer>[] adj;
    static ArrayList<Integer> A_order, B_order;
    static boolean[] isChild, visit;

    public static void init() throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            answer = 0;

            adj = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                adj[i] = new ArrayList<>();
            }

            isChild = new boolean[N + 1];
            visit = new boolean[N + 1];

            for (int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                adj[child].add(parent);
            }

            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            pro();
        }
    }

    private static void pro() throws IOException {
        A_order = new ArrayList<>();
        B_order = new ArrayList<>();

        findRoot(A, A_order);
        findRoot(B, B_order);

//        for (int x : A_order) {
//            bw.write(x + " ");
//        }
//        bw.newLine();
//        for (int x : B_order) {
//            bw.write(x + " ");
//        }
//        bw.newLine();

        int a_index = A_order.size();
        int b_index = B_order.size();

        while (true) {
            a_index--;
            b_index--;

            if (a_index < 0 || b_index < 0) break;

            int a = A_order.get(a_index);
            int b = B_order.get(b_index);

            if (a == b) {
                answer = a;
                continue;
            }
            if (a != b) {
                break;
            }
        }

        bw.write(answer + " ");
        bw.newLine();

    }

    private static void findRoot(int x, ArrayList<Integer> order) {
        order.add(x);

        if (adj[x].isEmpty()) return;

        x = adj[x].get(0);
        findRoot(x, order);
    }

    public static void main(String[] args) throws Exception {
        init();

        bw.close();
    }
}
