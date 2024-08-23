import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static int[] trees;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static boolean yesOrNo(int h) {
        long sum = 0;

        for (int i = 0; i < N; i++) {
            if (trees[i] > h) {
                sum += trees[i] - h;

            }
        }

        return sum >= M;
    }

    private static void pro() throws IOException {
        int start = 0;
        int end = 1_000_000_000;
        int result = 1_000_000_000;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (yesOrNo(mid)) {
                result = mid;

                start = mid + 1;
            } else {
                end = mid - 1;
            } 
        }
        
        bw.write(result + " ");

    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
