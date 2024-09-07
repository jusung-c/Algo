import java.io.*;
import java.util.*;

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
        int[] cnt = new int[26];
        int kind = 0;
        int length = 0;

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
                if (cnt[chars[R] - 'a'] == 1) {
                    kind++;
                }
            }

            if (kind > N) {
                cnt[chars[R] - 'a']--;
                R--;
                kind--;
            }

//            bw.write("L = " + L + " R = " + R);
//            bw.newLine();

            if (kind <= N) {
                length = Math.max(length, R - L + 1);
            }
        }

        bw.write(length + " ");

    }

    private static boolean checkValid(int[] cnt) {
        int val = 0;

        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > 0) val++;
        }

        return val <= N;
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
