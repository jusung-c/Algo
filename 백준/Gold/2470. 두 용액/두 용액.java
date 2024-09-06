import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[] liquid;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        liquid = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void pro() throws IOException {
        // 1. 용액 정렬
        Arrays.sort(liquid, 1, N + 1);

        // 2. 투 포인터
        int L = 1;  // 최소
        int R = N;  // 최대
        int r1 = 0;
        int r2 = 0;
        int ans = Integer.MAX_VALUE;

        while (L < R) {
            // 용액 혼합
            int sum = liquid[L] + liquid[R];
//            System.out.println(sum+" ");

            if (Math.abs(sum) < ans) {
                r1 = liquid[L];
                r2 = liquid[R];
                ans = Math.abs(sum);
//                System.out.println(result[0] + " " + result[1]);
            }

            // 0보다 큰 경우
            if (sum > 0) {
                R--;
            }

            // 0보다 작은 경우
            else {
                L++;
            }
        }

        bw.write(r1 + " " + r2);

    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}