import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[] arr, count;
    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        count = new int[Arrays.stream(arr).max().getAsInt() + 1];
    }

    private static void pro() throws IOException {
        long cnt = 0;
        int R = 0;

        // L 포인터 이동
        for (int L = 1; L <= N; L++) {
            count[arr[L-1]]--;

            while (R < N) {
                if (count[arr[R + 1]] == 0) {
                    R++;
                    count[arr[R]]++;
                } else {
                    break;
                }
            }

            cnt += R - L + 1;
        }

        bw.write(cnt + " ");

    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
