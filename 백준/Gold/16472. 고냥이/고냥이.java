import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static char[] chars;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        chars = br.readLine().toCharArray();
    }

    private static void pro() throws IOException {
        int R = -1;
        int[] cnt = new int[30];
        int kind = 0;
        int max = Integer.MIN_VALUE;

        for (int L = 0; L < chars.length; L++) {
            if (L != 0) {
                cnt[chars[L - 1] - 'a']--;

                if (cnt[chars[L - 1] - 'a'] == 0) {
                    kind--;
                }
            }

            while (R + 1 < chars.length && kind <= N) {
                R++;
                cnt[chars[R] - 'a']++;

                if (cnt[chars[R] - 'a'] == 1) kind++;
            }

            if (kind > N) {
                cnt[chars[R] - 'a']--;
                R--;
                kind--;
            }

            if (max < R - L + 1) {
//                bw.write("!!!! start= " + L + " end= " + R + " 길이 = " + (R - L + 1) + "\n");
                max = Math.max(max, R - L + 1);
            } else {
//                bw.write("@@@@ start= " + L + " end= " + R + " 길이 = " + (R - L + 1) + "\n");

            }
        }

        bw.write(max + " ");

    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
