import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int A, P;
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

    }

    private static void pro() throws IOException {
        dfs(A, P);

    }

    private static void dfs(int num, int P) throws IOException {
        if (arr.contains(num)){
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i) == num) {
                    bw.write(i + " ");
                }
            }
            return;
        }

        arr.add(num);

        int sum = 0;
        int mok = num;
        while (mok != 0) {
            sum += Math.pow(mok % 10, P);
            mok /= 10;
        }

        dfs(sum, P);
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
