import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int R, C, A;
    static int[][] map;
    static int[] total;

    public static void init() throws IOException {
        // R행 C열 의자 배치 (1 <= R, C <= 2000)
        // 각 의자마다 값이 있고, A(1 <= R <= C) 열의 의자 값들을 더했을 때 최대값을 출력하라

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        total = new int[C];
        for (int c = 0; c < C; c++) total[c] = findSum(c);


        A = Integer.parseInt(br.readLine());
    }

    private static void pro() throws IOException {
        int sum = 0;
        int max = 0;
        int size = 0;

        for (int R = -1, L = 0; L < C; L++) {
            if (L != 0) {
                sum -= total[L - 1];
                size--;
            }

            while (R + 1 < C & size < A) {
                sum += total[++R];
                size++;
            }

            max = Math.max(sum, max);
        }

        bw.write(max + " ");

    }

    private static int findSum(int c) {
        int sum = 0;
        for (int r = 0; r < R; r++) sum += map[r][c];
        return sum;
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
