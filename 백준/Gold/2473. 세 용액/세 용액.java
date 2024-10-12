import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int N;
    static int[] arr;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
    }

    private static void pro() throws IOException {
        Arrays.sort(arr);
        long ans = Long.MAX_VALUE;
        long A = 0;
        long B = 0;
        long C = 0;

        for (int i = 0; i < N - 2; i++) {
            int L = i + 1;
            int R = N - 1;
            long sum = 0;

            while (L < R) {
                sum = (long) arr[L] + arr[R] + arr[i];

                if (Math.abs(sum) < ans) {
                    ans = Math.abs(sum);
                    A = arr[i];
                    B = arr[L];
                    C = arr[R];
                }

                if (sum > 0) R--;
                else L++;
            }
        }

        bw.write(A + " ");
        bw.write(B + " ");
        bw.write(C + " ");
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
