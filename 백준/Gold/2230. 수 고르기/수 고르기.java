import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int N, M;
    static int[] arr;

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
    }

    private static void pro() throws IOException {
        int dist = 0;
        int min = Integer.MAX_VALUE;

        // 1 3 5

        for (int R = 0, L = 0; L < N; L++) {
            dist = arr[R] - arr[L];

            while (R + 1 < N && dist < M) {
                R++;
                dist = arr[R] - arr[L];
            }

            if (dist >= M) min = Math.min(min, dist);
        }

        bw.write(min + " ");
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
