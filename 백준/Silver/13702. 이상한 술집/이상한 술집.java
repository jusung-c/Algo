import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N, K;
    static int max = Integer.MAX_VALUE;
    static int[] size;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        size = new int[N];
        for (int i = 0; i < N; i++) {
            size[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, size[i]);
        }
    }

    private static boolean yesOrNo(long h) {
        long cnt = 0;

        for (int i = 0; i < N; i++) {
            cnt += size[i] / h;
        }

        return cnt >= K;
    }

    private static void pro() throws IOException {
        long start = 0;
        long end = max;
        long result = -1;

        while (start <= end) {
            long mid = (start + end) / 2;

            if (yesOrNo(mid)) {
                start = mid + 1;
                result = mid;
            } else {
                end = mid - 1;
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
