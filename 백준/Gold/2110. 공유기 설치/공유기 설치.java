import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N, C;
    static int max = Integer.MIN_VALUE;
    static int[] houses;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, houses[i]);
        }

        Arrays.sort(houses);
    }

    private static boolean yesOrNo(int h) {
        int cnt = 1;
        int pre = houses[0];

        for (int i = 1; i < N; i++) {
            if (pre + h > houses[i]) continue;

            cnt++;
            pre = houses[i];
        }

        return cnt >= C;
    }

    private static void pro() throws IOException {
        int start = 0;
        int end = max;
        int result = -1;

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
