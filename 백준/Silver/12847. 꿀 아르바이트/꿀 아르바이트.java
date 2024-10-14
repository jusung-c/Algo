import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int N, M;
    static int[] money;

    public static void init() throws IOException {
        // n (1 ≤ n ≤ 100,000) 일과 일을 할 수 있는 날 m (0 ≤ m ≤ n) 일이 주어진다.
        // 멈추지 않고 m일을 했을 때 최대로 받을 수 있는 월급은?
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        money = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) money[i] = Integer.parseInt(st.nextToken());
    }

    private static void pro() throws IOException {
        long sum = 0;
        int size = 0;
        long max = 0;

        for (int R = -1, L = 0; L < N - M + 1; L++) {
            if (L != 0) {
                sum -= money[L - 1];
                size--;
            }

            while (R + 1 < N && size < M) {
                sum += money[++R];
                size++;
            }

            if (size == M) max = Math.max(max, sum);
        }

        bw.write(max + " ");

    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
