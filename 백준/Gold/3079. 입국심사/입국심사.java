import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static int min = Integer.MAX_VALUE;
    static int[] times;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        times = new int[N];

        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(br.readLine());
            min = Math.min(min, times[i]);
        }
    }

    private static boolean yesOrNo(long k) {
        long cnt = 0;

        for (int i = 0; i < N; i++) {
            cnt += k / times[i];

            // 오버플로우 신경쓰기
            if (cnt >= M) return true; 
        }

        return cnt >= M;
    }

    private static void pro() throws IOException {
        long start = min;
        long end = 1_000_000_000_000_000_000L;
        long result = -1;

        while (start <= end) {
            long mid = (start + end) / 2;

            if (yesOrNo(mid)) {
                result = mid;
                end = mid - 1;
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
