import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static int[] A, B;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];
        B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

    }

    private static void pro() throws IOException {
        int[] ans = new int[N + M];
        int index = 0;

        int a_point = 0;
        int b_point = 0;

        while (a_point < N && b_point < M) {
            if (A[a_point] < B[b_point]) {
                ans[index] = A[a_point];
                a_point++;
            } else {
                ans[index] = B[b_point];
                b_point++;
            }

            index++;
        }

        if (a_point == N) {
            for (int i = b_point; i < M; i++) {
                ans[index] = B[i];
                index++;
            }
        } else {
            for (int i = a_point; i < N; i++) {
                ans[index] = A[i];
                index++;
            }
        }

        for (int a : ans) {
            bw.write(a + " ");
        }

    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
