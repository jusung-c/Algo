import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static int[] arr;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void pro() throws IOException {
        Arrays.sort(arr, 1, N + 1);

        int R = 0;
        int diff = 0;
        int min = Integer.MAX_VALUE;

        for (int L = 1; L <= N; L++) {
            if (R != 0) {
                diff = arr[R] - arr[L];
            }

            while (R + 1 <= N && diff < M) {
                R++;
                diff = arr[R] - arr[L];
            }

            if (diff >= M) {
                min = Math.min(min, diff);
            }
        }

        bw.write(min + " ");

    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
