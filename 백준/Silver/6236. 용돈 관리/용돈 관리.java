import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static int max = Integer.MIN_VALUE;
    static int[] requests;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        requests = new int[N];
        for (int i = 0; i < N; i++) {
            requests[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, requests[i]);
        }
    }

    private static boolean yesOrNo(int k) {
        int cnt = 1;
        int money = k;

        for (int i = 0; i < N; i++) {
            if (requests[i] <= money) {
                money -= requests[i];
            } else {
                cnt++;
                money = k - requests[i];
            }
        }

        return cnt <= M;
    }

    private static void pro() throws IOException {
        int start = max;
        int end = 1_000_000_000;
        int result = -1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (yesOrNo(mid)) {
                end = mid - 1;
                result = mid;
            } else {
                start = mid + 1;
            }
        }

        bw.write(result + " ");

    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
