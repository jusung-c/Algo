import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int[] A;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void pro() throws IOException {
        Arrays.sort(A, 1, N + 1);

        int R = 1;
        int gap = 0;
        int ans = Integer.MAX_VALUE;

        for (int L = 1; L <= N; L++) {
            gap = A[R] - A[L];

            while (R < N && gap < M) {
                R++;
                gap = A[R] - A[L];
            }

            if (gap >= M) {
                ans = Math.min(ans, gap);
//                bw.write(ans+" ");
            }
        }

        bw.write(ans + " ");
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
