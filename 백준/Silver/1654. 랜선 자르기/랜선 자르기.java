import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static int[] lines;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lines = new int[N];
        for (int i = 0; i < N; i++) {
            lines[i] = Integer.parseInt(br.readLine());
        }
    }

    private static boolean yesOrNo(long h) throws IOException {
        long cnt = 0;

        for (int i = 0; i < N; i++) {
            cnt += lines[i] / h;
        }

        return cnt >= M;
    }

    private static void pro() throws IOException {
        long start = 0;
        long end = Integer.MAX_VALUE;
        long result = Integer.MAX_VALUE;

        while (start <= end) {
            long mid = (start + end) / 2;

            if (yesOrNo(mid)) {
                result = mid;
                start = mid + 1;
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
