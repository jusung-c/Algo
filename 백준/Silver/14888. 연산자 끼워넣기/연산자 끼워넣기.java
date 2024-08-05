import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int numCnt, N;
    static int[] numbers, opcode, selected;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        numCnt = Integer.parseInt(br.readLine());
        N = numCnt - 1;

        numbers = new int[numCnt];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numCnt ; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        selected = new int[N + 1];
        opcode = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            opcode[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void pro(int k) throws IOException {
        // 종료 조건
        if (k == N + 1) {
            int num = cal(selected);

            max = Math.max(max, num);
            min = Math.min(min, num);

            return;
        }

        for (int i = 0; i < 4; i++) {
            if (opcode[i] == 0) continue;

            selected[k] = i;
            opcode[i]--;

            pro(k + 1);

            selected[k] = 0;
            opcode[i]++;

        }
    }

    private static int cal(int[] selected) {
        int result = numbers[0];

        for (int i = 1; i <= N; i++) {
            switch (selected[i]) {
                case 0:
                    result += numbers[i];
                    break;
                case 1:
                    result -= numbers[i];
                    break;
                case 2:
                    result *= numbers[i];
                    break;
                case 3:
                    result /= numbers[i];
                    break;
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        init();

        pro(1);

        bw.write(max + "\n");
        bw.write(min + "\n");

        bw.close();
    }
}
