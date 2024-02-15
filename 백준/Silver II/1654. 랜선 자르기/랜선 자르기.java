import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int K, N;
    static int[] lan;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine(), " ");
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        lan = new int[K + 1];
        for (int i = 1; i <= K; i++) {
            lan[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void pro() {
        // 이분탐색 진행 -> 범위: 1 ~ 2^31-1
        long start = 1;
        long end = Integer.MAX_VALUE;
        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;

            if (YesOrNo(mid)) {
//                System.out.println("Yes!");
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);

    }

    private static boolean YesOrNo(long D) {
        int sum = 0;

        for (int i = 1; i <= K; i++) {
            sum += lan[i] / D;
        }

        return sum >= N;
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
