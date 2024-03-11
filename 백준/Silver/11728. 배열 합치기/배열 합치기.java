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
    static int N, M;
    static int[] A, B, result;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N + 1];
        B = new int[M + 1];
        result = new int[N + M + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

    }

    private static void pro() throws IOException {
        int A_idx = 1;
        int B_idx = 1;
        int result_idx = 1;

        while (A_idx <= N && B_idx <= M) {
            if (A[A_idx] <= B[B_idx]) {
                result[result_idx] = A[A_idx];
                A_idx++;
                result_idx++;
            } else {
                result[result_idx] = B[B_idx];
                B_idx++;
                result_idx++;
            }
        }

        if (A_idx != N + 1) {
            for (int i = A_idx; i <= N; i++) {
                result[result_idx] = A[i];
                result_idx++;
            }
        } else {
            for (int i = B_idx; i <= M; i++) {
                result[result_idx] = B[i];
                result_idx++;
            }
        }


        for (int i = 1; i <= result.length - 1; i++) {
            bw.write(result[i] + " ");
        }

    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
