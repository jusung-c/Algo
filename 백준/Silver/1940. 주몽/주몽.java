import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static int[] nums;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        nums = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

    }

    private static void pro() throws IOException {
        Arrays.sort(nums);

        // 1 2 3 4 5 7

        int L = 1;
        int R = N;
        int sum = 0;
        int cnt = 0;

        while (L < R) {
            sum = nums[L] + nums[R];

            if (sum == M) {
                cnt++;
                L++;
                R--;
            } else if (sum < M) {
                L++;
            } else {
                R--;
            }
        }

        bw.write(cnt + " ");
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
