import java.io.*;
import java.time.LocalDate;
import java.util.StringTokenizer;

/*
    0. 문제
        - 숫자 1, 2, 3으로 이루어진 수열
        - 임의의 길이의 인접한 두 개의 부분 수열이 동일한 것이 있으면 나쁜 수열이고
        그렇지 않으면 좋은 수열이다.
        - 길이가 N인 좋은 수열 중 가장 작은 수를 구하라 (1 <= N <= 80)

    1. 아이디어
        - 중복을 허용하고 순서가 있도록 N개의 수를 뽑는다.
        - 다 뽑으면 좋은 수열인지 확인한 후 맞다고 출력하고 종료한다.

    2. 시간 복잡도

 */

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int M;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        M = Integer.parseInt(br.readLine());
    }

    private static void pro(String s) throws IOException {
        if (s.length() == M) {
            bw.write(s);
            bw.close();
            System.exit(0);

        } else {
            for (int i = 1; i <= 3; i++) {
                if (isGood(s + i)) pro(s + i);
            }
        }
    }

    // 좋은 수열 체크
    private static boolean isGood(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {

            // 마지막 i개
            String back = s.substring(s.length() - i);

            // 그 전의 i개
            String front = s.substring(s.length() - 2 * i, s.length() - i);

            // 비교
            if (back.equals(front)) return false;
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        init();

        pro("");

        bw.close();
    }
}
