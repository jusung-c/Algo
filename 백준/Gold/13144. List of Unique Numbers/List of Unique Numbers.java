import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int[] arr;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

    }

    private static void pro() throws IOException {
        int R = 0;
        int[] cnt = new int[1000000];
        long ans = 0;

        for (int L = 1; L <= N; L++) {
            cnt[arr[L - 1]]--;

            while (R + 1 <= N && cnt[arr[R + 1]] == 0) {
                R++;
                cnt[arr[R]]++;
            }

//            bw.write("L = " + L + " R = " + R);
//            bw.newLine();

            ans += R - L + 1;
        }

        bw.write(ans + " ");

    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
