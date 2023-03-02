import java.io.*;
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
        int L = 1;
        int R = N;
        int r1 = 0;
        int r2 = 0;
        int ans = Integer.MAX_VALUE;

        while (L < R) {
            int sum = A[L] + A[R];

            if (ans > Math.abs(sum)) {
                ans = Math.abs(sum);
                r1 = A[L];
                r2 = A[R];
            }

            if (sum > 0) {
                R--;
            } else {
                L++;
            }
        }

        bw.write(r1 + " " + r2);
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}


// N개의 용액 (2 <= N <= 10만)
// -10억 <= 각 용액 <= 10억
// 두 용액을 합쳐 특성값이 0에 가장 가까운 두 용액을 찾아라

// 1. 최대, 최소 용액에 포인터를 두고 더해서 0과 비교
// 2. 0보다 크면 갱신 후 최대 제외
// 3. 0보다 작으면 갱신 후 최소 제외
// 4. 0이면 그냥 답이므로 출력