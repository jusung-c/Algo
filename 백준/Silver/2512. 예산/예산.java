import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static int max = Integer.MIN_VALUE;
    static int[] list;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, list[i]);
        }

        M = Integer.parseInt(br.readLine());
    }

    private static boolean yesOrNo(int h) {
        long sum = 0;

        for (int i = 0; i < N; i++) {
            if (list[i] >= h) sum += h;
            else sum += list[i];
        }

        return sum <= M;
    }

    private static void pro() throws IOException {
        int start = 0;
        int end = 100_000;
        int result = -1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (yesOrNo(mid)) {
                result = mid;

                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        result = Math.min(max, result);

        bw.write(result + " ");

    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
