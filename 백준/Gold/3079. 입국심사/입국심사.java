import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    0. 문제
        - 조건: M명이 N개의 입국심사대에서 심사
        - 타겟: 걸리는 시간 T

    1. 아이디어
        - 주어진 시간 T 동안 M명이 N개의 입국심사대를 통과할 수 있는가?
        -

    2. 시간 복잡도

 */

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static int[] time;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        time = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            time[i] = Integer.parseInt(br.readLine());
        }

    }

    private static void pro() throws IOException {
        long start = Arrays.stream(time).min().getAsInt();
        long end = (long) Arrays.stream(time).max().getAsInt() * M;
        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;

            if (yesOrNo(mid)) {
                result = mid;

                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        bw.write(result + "");

    }

    private static boolean yesOrNo(long T) {
        long sum = 0;

        for (int i = 1; i <= N; i++) {
            sum += T / time[i];

            if (sum >= M) {
                return true;
            }
        }

        return sum >= M;
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
