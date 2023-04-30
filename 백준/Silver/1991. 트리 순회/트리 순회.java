import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[][] childs;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        childs = new int[30][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char curCh = st.nextToken().charAt(0);
            int cur = curCh - 'A';

            for (int k = 0; k < 2; k++) {
                char ch = st.nextToken().charAt(0);
                if (ch != '.') childs[cur][k] = ch - 'A';
                else childs[cur][k] = -1;
            }
        }
    }

    private static void pro() throws IOException {
        pre_order(0);
        bw.write("\n");
        in_order(0);
        bw.write("\n");
        post_order(0);

    }

    private static void post_order(int x) throws IOException {
        if (x == -1) return;
        post_order(childs[x][0]);
        post_order(childs[x][1]);
        bw.write((char)(x + 'A'));
    }

    private static void in_order(int x) throws IOException {
        if (x == -1) return;
        in_order(childs[x][0]);
        bw.write((char)(x + 'A'));
        in_order(childs[x][1]);
    }

    private static void pre_order(int x) throws IOException {
        if (x == -1) return;
        bw.write((char)(x + 'A'));
        pre_order(childs[x][0]);
        pre_order(childs[x][1]);
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
