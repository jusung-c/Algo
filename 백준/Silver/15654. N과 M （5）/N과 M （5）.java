import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    0. 문제

    1. 아이디어

    2. 시간 복잡도

 */

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static int[] selected, numbers;
    static boolean[] isUsed;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        selected = new int[M + 1];
        numbers = new int[N + 1];
        isUsed = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
    }

    private static void pro(int k) throws IOException {
        // 종료 조건
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                bw.write(selected[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (isUsed[i]) continue;

            selected[k] = numbers[i];
            isUsed[i] = true;

            pro(k + 1);

            selected[k] = 0;
            isUsed[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        // 재귀로 가능한 모든 수 탐색
        pro(1);

        bw.close();
    }
}
