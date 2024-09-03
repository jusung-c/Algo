import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N, K;
    static int[] arr;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void pro() throws IOException {
        int r = 0;
        int cnt = 0;
        int min = Integer.MAX_VALUE;

        for (int l = 1; l <= N; l++) {
            if (arr[l-1] == 1) cnt--;

            while (r + 1 <= N && cnt < K) {
                r++;
                if (arr[r] == 1) cnt++;
            }

            if (cnt >= K) {
                min = Math.min(min, r - l + 1);
            }
        }

        if (min == Integer.MAX_VALUE) {
            bw.write("-1");
        } else {
            bw.write(min + " ");
        }

    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
