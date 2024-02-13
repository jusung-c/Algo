import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static long K;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());
    }

    private static void pro() throws IOException {
        int start = 0;
        int end = N / 2;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (paper(mid) == K) {
                bw.write("YES");
                return;
            } else if (paper(mid) > K) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        bw.write("NO");

    }

    private static long paper(int value) {
        long a = value;
        long b = N - value;
        return (a + 1) * (b + 1);
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
