import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N;
    static int max = Integer.MIN_VALUE;
    static int[] nums, selected, used;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        selected = new int[N + 1];
        used = new int[N + 1];
    }

    public static void main(String[] args) throws IOException {
        init();

        func(1);

        bw.write(max+" ");

        br.close();
        bw.close();
    }

    private static void func(int k) {
        if (k == N + 1) {
            // max 갱신
            cal();
        } else {
            for (int i = 1; i <= N; i++) {
                if(used[i] == 1) continue;
                selected[k] = nums[i];
                used[i] = 1;

                func(k + 1);

                selected[k] = 0;
                used[i] = 0;
            }
        }
    }

    private static void cal() {
        int sum = 0;
        for (int i = 2; i <= N; i++) {
            sum += Math.abs(selected[i] - selected[i - 1]);
        }

        max = Math.max(max, sum);
    }
}
