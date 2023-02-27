import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] A, B, result;

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        B = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        result = new int[N + M + 1];
    }

    static void pro() {
        int L = 1;
        int R = 1;
        int i = 1;

        while (L <= N && R <= M) {
            if (A[L] <= B[R]) {
                result[i] = A[L];
                i++;
                L++;
            } else {
                result[i] = B[R];
                i++;
                R++;
            }
        }

        while (L <= N) {
            result[i] = A[L];
            i++;
            L++;
        }

        while (R <= M) {
            result[i] = B[R];
            i++;
            R++;
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        pro();

        for (int i = 1; i <= result.length - 1; i++) {
            bw.write(result[i] + " ");
        }

        bw.close();
    }

}