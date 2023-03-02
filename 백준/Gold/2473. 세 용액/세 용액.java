import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[] A;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void pro() throws IOException {
        Arrays.sort(A, 1, N + 1);

        long ans = Long.MAX_VALUE;
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;

        for (int i = 1; i <= N - 2; i++) {
            int L = i + 1;
            int R = N;

            while (L < R) {
                long sum = (long) A[i] + (long) A[L] + (long) A[R];
//                bw.write(sum+"\n");

                if (Math.abs(sum) < ans) {
                    ans = Math.abs(sum);
                    r1 = A[i];
                    r2 = A[L];
                    r3 = A[R];
                }

                if (sum > 0) {
                    R--;
                } else {
                    L++;
                }
            }
        }

        bw.write(r1+" " + r2 + " " + r3);

    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
