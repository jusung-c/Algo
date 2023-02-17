import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] lecture;

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lecture = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            lecture[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() throws IOException {
        // 이분 탐색
        int L = lecture[1];
        for (int i = 1; i <= N; i++) {
            L = Math.max(L, lecture[i]);
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

    // Yes or No 결정문제
    static boolean YesOrNo(int S) {
        int cnt = 1;
        int sum = 0;

        for (int i = 1; i <= N; i++) {
            // 강의 녹화하면 S 넘는지 확인
            if (sum + lecture[i] > S) {
                // 넘으면 cnt++
                cnt++;
                // 다음을 위해 새로 녹화(새로 0에 더해주기)
                sum = lecture[i];

            // 아니면 그대로 녹화(더해주기)
            } else {
                sum += lecture[i];
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