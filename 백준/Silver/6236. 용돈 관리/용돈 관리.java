import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M, sum;
    static int[] amount;

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        amount = new int[N + 1];
        sum = 0;
        for (int i = 1; i <= N; i++) {
            amount[i] = Integer.parseInt(br.readLine());
            sum += amount[i];
        }

    }

    static void pro() throws IOException {
        // 이분 탐색
        int L = amount[1];
        for (int i = 1; i <= N; i++) {
            L = Math.max(amount[i], L);
        }

        int R = 1000000000;
        int ans = 0;

        while (L <= R) {
            int mid = (L + R) / 2;

            if (YesOrNo(mid)) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

        bw.write(ans+" ");
    }

    static boolean YesOrNo(int K) {
        int sum = 0;
        int cnt = 1;

        for (int i = 1; i <= N; i++) {
            // 금액이 인출한 K보다 클 경우
            if(sum + amount[i] > K) {
                // 한번 더 인출
                cnt++;
                // 새로 인출했으니 sum 갱신
                sum = amount[i];

            // K 안에서 해결 가능한 경우
            } else {
                sum += amount[i];
            }
        }

        return cnt <= M;
    }

    public static void main(String[] args) throws IOException {
        init();

        pro();

        bw.close();
    }

}