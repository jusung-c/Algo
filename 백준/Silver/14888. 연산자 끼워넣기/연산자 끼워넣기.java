import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;

    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] num, operator, selected;

    static final int M = 4;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = new int[N + 1];
        operator = new int[M + 1];
        selected = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= M; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void pro(int k, int value) throws IOException {
        if (k == N) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            for (int i = 1; i <= M; i++) {
                if (operator[i] == 0) continue;

                operator[i]--;
                selected[k] = i;

                pro(k + 1, calculate(value, i, num[k + 1]));

                operator[i]++;
                selected[k] = 0;
            }
        }


    }

    private static int calculate(int value, int operator, int operand) {
        if (operator == 1) {
            return value += operand;
        }

        if (operator == 2) {
            return value -= operand;
        }

        if (operator == 3) {
            return value *= operand;
        }

        if (operator == 4) {
            return value /= operand;
        }

        return value;
    }

    public static void main(String[] args) throws Exception {
        init();

        pro(1, num[1]);

        bw.write(max + "\n");
        bw.write(min + "\n");

        bw.close();
    }
}
