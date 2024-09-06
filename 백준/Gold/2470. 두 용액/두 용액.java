import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int[] liquids;
    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        liquids = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            liquids[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(liquids, 1, N + 1);
    }

    private static void pro() throws IOException {
        int A = 0;
        int B = 0;


        int l = 1;
        int r = N;
        int min = Integer.MAX_VALUE;

        while (l < r) {
            int sum = liquids[l] + liquids[r];
            int sum_abs = Math.abs(sum);

            // 최솟값 갱신
            if (sum_abs < min) {
                A = liquids[l];
                B = liquids[r];
                min = sum_abs;
            }

            // l의 최선
            if (sum == 0) {
                bw.write(A + " " + B);
                bw.close();
                System.exit(0);
            } else if (sum < 0) {
                l++;
            } else {
                r--;
            }
        }

        bw.write(A + " " + B);
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
