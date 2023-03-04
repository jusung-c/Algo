import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, kind;
    static String s;
    static int[] cnt;
    static char[] arr;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        s = br.readLine();
        cnt = new int[26];
        arr = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }
    }

    private static void pro() throws IOException {
        int ans = 0;

        for (int L = 0, R = 0; R < s.length(); R++) {
            // R 번째 문자 추가
            cnt[arr[R] - 'a']++;

            // 불가능하면 가능할 때까지 L을 이동
            while (true) {
                kind = 0;
                for (int i = 0; i < 26; i++) {
                    if (cnt[i] != 0) {
                        kind++;
                    }
                }

                if (kind <= N) {
                    break;
                }

                // L 문자 삭제 후 포인터 이동
                cnt[arr[L] - 'a']--;
                L++;
            }

            // 정답 갱신
            ans = Math.max(ans, R - L + 1);
        }

        bw.write(ans+" ");
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
