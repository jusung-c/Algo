import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int[] time;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        time = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            time[i] = Integer.parseInt(br.readLine());
        }
    }

    private static boolean YesOrNo(long T) {
        long sum = 0;

        for (int i = 1; i <= N; i++) {
            sum += T / time[i];
            
            // 오버플로우 신경쓰기
            if (sum >= M) {
                return true;
            }
        }

        return sum >= M;
    }

    private static void pro() throws IOException {
        long start = Arrays.stream(time).min().getAsInt();
        long end = (long) Arrays.stream(time).max().getAsInt() * M;
        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;

            if (YesOrNo(mid)) {
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
