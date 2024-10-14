import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ;
    static StringTokenizer st;
    static int N, target, B;
    static int[] arr;

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        for (int i = 1; i <= B; i++) {
            int x = Integer.parseInt(br.readLine());
            arr[x] = 1;
        }

//        for (int i : arr) bw.write(i + " ");
//        bw.newLine();
    }

    private static void pro() throws IOException {
        int cnt = 0;
        int size = 1;
        int min = Integer.MAX_VALUE;

        for (int R = 0, L = 1; L <= N; L++) {
            if (arr[L - 1] == 1) cnt--;
            size--;

            while (R + 1 <= N && size < target) {
                R++;
                if (arr[R] == 1) cnt++;
                size++;
            }

//            bw.write("L = " + L + " R = " + R + " cnt = " + cnt);
//            bw.newLine();

            if (size == target) min = Math.min(min, cnt);
        }

        bw.write(min + " ");
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
