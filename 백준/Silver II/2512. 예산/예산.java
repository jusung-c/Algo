import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] plz;

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        plz = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            plz[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
    }

    static void pro() throws IOException {
        // 이분탐색
        int L = 0;
        int R = 0;
        for (int i = 1; i <= N; i++) {
            R = Math.max(plz[i], R);
        }

        int ans = 0;

        while (L <= R) {
            int mid = (L + R) / 2;

            if (YesOrNo(mid) == true) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }

        bw.write(ans+" ");
    }

    static boolean YesOrNo(int H) {
        int sum = 0;

        for (int i = 1; i <= N; i++) {
            sum += Math.min(H, plz[i]);
        }

        if (sum <= M) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        pro();

        bw.close();
    }

}