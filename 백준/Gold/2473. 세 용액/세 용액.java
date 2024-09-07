import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N, A, B, C;
    static int[] arr;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void pro() throws IOException {
        Arrays.sort(arr);

        long ans = Long.MAX_VALUE;
        long A = 0;
        long B = 0;
        long C = 0;

        for (int i = 0; i < N - 2; i++) {
            long target = arr[i];
            int L = i + 1;
            int R = N - 1;

            while (L < R) {
                long sum = target + arr[L] + arr[R];

                if (Math.abs(sum) < ans) {
                    ans = Math.abs(sum);
                    A = target;
                    B = arr[L];
                    C = arr[R];
                }

                if (sum > 0) {
                    R--;
                } else {
                    L++;
                }
            }
        }

        bw.write(A + " " + B + " " + C + " ");
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
