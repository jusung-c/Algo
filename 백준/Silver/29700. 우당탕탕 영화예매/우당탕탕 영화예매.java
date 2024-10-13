import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int C, R, member;
    static String[] map;

    public static void init() throws IOException {
        // R(1~5000) x C(1~1000) map과 K(1~10)가 주어진다.
        // map에서 연속으로 0이 K개인 행의 개수를 구하라

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        member = Integer.parseInt(st.nextToken());
        map = new String[R];
        for (int i = 0; i < R; i++) map[i] = br.readLine();
    }

    private static void pro() throws IOException {
        int answer = 0;

        // 한줄씩 연속된 K개의 0이 있는지 확인한다.
        for (int i = 0; i < R; i++) answer += checkSeat(map[i]);

        bw.write(answer + " ");
    }

    private static int checkSeat(String row) {
        int size = 0;
        int cnt = 0;

        for (int R = -1, L = 0; L < C; L++) {
            if (L != 0) size--;

            while (R + 1 < C && size < member) {
                R++;

                // 빈 자리인지 체크
                if (row.charAt(R) == '0') {
                    size++;
                } else {
                    L = R;
                    size = 1;
                    break;
                }
            }

            if (size == member && row.charAt(R) == '0') cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
