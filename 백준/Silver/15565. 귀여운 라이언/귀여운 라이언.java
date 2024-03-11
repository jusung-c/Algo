import java.io.*;
import java.util.StringTokenizer;

/*
    0. 문제

    1. 아이디어

    2. 시간 복잡도

 */

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N, K;
    static int[] dolls;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dolls = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            dolls[i] = Integer.parseInt(st.nextToken());
        }

    }

    private static void pro() throws IOException {
        int R = 0;
        int cnt = 0;
        int size = N + 1;

        for (int L = 1; L <= N; L++) {
            if (dolls[L - 1] == 1) {
                cnt--;
            }

            while (R + 1 <= N && cnt < K) {
                R++;
                if(dolls[R] == 1) cnt++;
            }

            if (cnt >= K) size = Math.min(size, R - L + 1);
        }

        if (size == N + 1) {
            bw.write("-1");
        } else {
            bw.write(size + " ");
        }

    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
