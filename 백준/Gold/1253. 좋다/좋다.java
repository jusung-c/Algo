import java.io.*;
import java.util.Arrays;
import java.util.Collections;
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
        arr = new int[N ];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void pro() throws IOException {
        int ans = 0;

        // 1. 내림차순 정렬
        int[] reverse = Arrays.stream(arr)      // IntStream
                .boxed()        // Stream<Integer>
                .sorted(Collections.reverseOrder())     // Stream<Integer>
                .mapToInt(Integer::intValue)            // IntStream
                .toArray();// int[]

        // 2. 좋은 수인지 판별
        for (int i = 0; i < N; i++) {
            int cand = reverse[i];

            // 좋은 수이면 ans++
            if (checkGood(i, cand, reverse)) ans++;
        }

        bw.write(ans + " ");

    }

    private static boolean checkGood(int start, int target, int[] reverse) throws IOException {
        int R = N - 1;
        int sum = 0;

        for (int L = 0; L < R; L++) {
            if (start == L) continue;
            if (start == R) R--;

            sum = reverse[L] + reverse[R];

            while (L < R - 1 && sum < target) {
                R--;
                if (R == start) continue;
                sum = reverse[L] + reverse[R];
            }

//            bw.write("=== 기준: " + target + "===\n");

            if (sum == target) {
//                bw.write("!!!!reverse[L] = " + reverse[L] + " reverse[R] = " + reverse[R] + " sum = " + sum);
//                bw.newLine();
                return true;
            } else {
//                bw.write("@@@@reverse[L] = " + reverse[L] + " reverse[R] = " + reverse[R] + " sum = " + sum);
//                bw.newLine();
            }
        }

        return false;
    }

    // 3 2 1 0 -1

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
