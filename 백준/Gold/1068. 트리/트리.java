import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int N, root, remove_num;
    static ArrayList<Integer>[] child;
    static int[] leaf;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        child = new ArrayList[N];
        for (int i = 0; i < N; i++) child[i] = new ArrayList<>();

        leaf = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());

            if (parent == -1) {
                root = i;
                continue;
            }

            child[parent].add(i);
        }

        remove_num = Integer.parseInt(br.readLine());
    }

    private static void pro() throws IOException {
        for (int i = 0; i < N; i++) {
            if (child[i].contains(remove_num))
                child[i].remove((Integer) remove_num);
        }

        if (root == remove_num) {
            System.out.println(leaf[root] + " ");
        } else {
            dfs(root, -1);
            System.out.println(leaf[root] + " ");
        }
    }

    private static void dfs(int x, int parent) {
        if (child[x].isEmpty()) leaf[x]++;

        for (int y : child[x]) {
            dfs(y, x);
            leaf[x] += leaf[y];
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
