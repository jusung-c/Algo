import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N, K;
    static int[] temp;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        temp = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void pro() throws IOException {
        int r = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < K; i++) {
            r++;
            sum += temp[r];
        }

        for (int l = 1; l <= N; l++) {

            sum -= temp[l - 1];

            if (r + 1 <= N) {
                r++;
                sum += temp[r];

            } else {
                break;
            }

            max = Math.max(max, sum);
        }

        bw.write(max + " ");

    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
