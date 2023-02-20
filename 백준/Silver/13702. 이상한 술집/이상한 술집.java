import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, K;
    static int[] arr;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    private static boolean YesOrNo(long W) {
        int sum = 0;

        for (int i = 1; i <= N; i++) {
            sum += arr[i] / W;
        }

        return sum >= K;
    }

    private static void pro() throws IOException {
        long start = 1;
        long end = Arrays.stream(arr).max().getAsInt();
        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;

            if (YesOrNo(mid)) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        bw.write(result+" ");

    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
