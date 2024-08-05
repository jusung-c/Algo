import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static int[] selected, numbers;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        selected = new int[M + 1];

        numbers = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
    }

    private static void pro(int k, int prev) throws IOException {
        // 종료 조건
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                bw.write(selected[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = prev; i <= N; i++) {
            selected[k] = numbers[i];
            pro(k + 1, i);
            selected[k] = 0;
        }

    }

    public static void main(String[] args) throws Exception {
        init();

        pro(1, 1);

        bw.close();
    }
}
