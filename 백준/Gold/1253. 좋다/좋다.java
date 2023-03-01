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
        // 1. 배열 정렬
        Arrays.sort(A, 1, N + 1);

        int ans = 0;

        // 2. 타겟 결정
        for (int i = 1; i <= N; i++) {
            int target = A[i];

            // 3. 투 포인터로 타겟이 되는 경우의 수 체크
            int L = 1, R = N;
            while (L < R) {
                if (L == i) {
                    L++;
                } else if (R == i) {
                    R--;
                } else {
                    if (A[L] + A[R] == target) {
                        ans++;
                        break;
                    } else if (A[L] + A[R] > target) {
                        R--;
                    } else {
                        L++;
                    }
                }
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
