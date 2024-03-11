import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, K;
    static int[] temp;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        temp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void pro() throws IOException {
        int R = 0;
        int result = 0;
        int day = 1;
        int ans = Integer.MIN_VALUE;

        for (int L = 1; L <= N - K + 1; L++) {
            result -= temp[L - 1];
            day--;

            while (R + 1 <= N && day < K) {
                R++;
                day++;
                result += temp[R];
            }

            ans = Math.max(ans, result);
//            bw.write(ans+" ");
        }

        bw.write(ans + " ");
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
