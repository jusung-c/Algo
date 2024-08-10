import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
    }

    private static void pro(int k, StringBuilder sb) throws IOException {
        // 종료 조건
        if (k == N) {
            bw.write(sb.toString());
            bw.close();
            System.exit(0);
        }

        // 재귀 정의
        for (int i = 1; i <= 3; i++) {
            // i를 붙였을 때 나쁜 수열일 경우
            if (isBad(sb.toString() + i)) continue;

            sb.append(i);

            pro(k + 1, sb);

            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private static boolean isBad(String s) {
        for (int i = s.length() - 1; i >= 0 ; i--) {
            String check = s.substring(i);
            if (i - check.length() < 0) continue;
            String target = s.substring(i - check.length(), i);

            if (check.equals(target)) return true;
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        init();

        pro(0, new StringBuilder());

        bw.close();
    }
}
