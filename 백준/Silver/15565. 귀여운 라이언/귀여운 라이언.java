import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, K;
    static int[] nums;

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() throws IOException {
        int R = 0;
        int ans = 0;
        int result = Integer.MAX_VALUE;

        for (int L = 1; L <= N; L++) {

            if (nums[L-1] == 1) {
                ans--;
            }

            while (R + 1 <= N && ans < K) {
                R++;
                if (nums[R] == 1) {
                    ans++;
                }
            }

            if (ans >= K) {
                result = Math.min(result, R - L + 1);
            }

        }

        if (result > 0 && result <= N) {
            bw.write(result + " ");
        } else {
            bw.write(-1 + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        pro();

        bw.close();
    }
}