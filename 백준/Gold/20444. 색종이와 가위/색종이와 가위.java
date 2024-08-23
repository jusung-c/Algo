import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static long K;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());

    }

    private static void pro() throws IOException {
        int start = 0;
        int end = N / 2;

        while (start <= end) {
            int mid = (start + end) / 2;
            long result = cal(mid);

            if (result == K) {
                bw.write("YES");
                return;
            } else if (result > K) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        bw.write("NO");

    }

    private static long cal(int mid) {
        long ka = mid;
        long se = N - mid;

        return (ka + 1) * (se + 1);
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
