import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] nums;

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() throws IOException {
        int R = 0;
        int sum = 0;
        int ans = 0;

        for (int L = 1; L <= N; L++) {
            sum -= nums[L - 1];

            while (R + 1 <= N && sum < M) {
                R++;
                sum += nums[R];
            }

            if (sum == M) {
                ans++;
            }

        }

        bw.write(ans+" ");
    }

    public static void main(String[] args) throws IOException {
        init();

        pro();

        bw.close();
    }

}