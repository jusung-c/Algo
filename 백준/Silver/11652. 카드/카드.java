import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static long[] cards;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cards = new long[N];

        for (int i = 0; i < N; i++) {
            cards[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(cards);
    }

    private static void pro() throws IOException {

        int max_cnt = 1;
        int curr_cnt = 1;
        long max_value = cards[0];

        for (int i = 1; i < N; i++) {
            if (cards[i] == cards[i-1]) {
                curr_cnt++;

                if (max_cnt < curr_cnt) {
                    max_value = cards[i];
                    max_cnt = curr_cnt;
                }
            } else {
                curr_cnt = 1;
            }
        }

        bw.write(max_value + " ");
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
