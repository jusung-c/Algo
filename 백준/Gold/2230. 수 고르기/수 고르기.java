import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static int[] arr;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void pro() throws IOException {
        // 1. 정렬
        Arrays.sort(arr);

        // 2. 투 포인터로 두 포인터 값의 최소를 갱신해나가면서 전 범위 탐색하기
        int r = 0;
        int diff = 0;
        int min = Integer.MAX_VALUE;

        for (int l = 1; l <= N; l++) {
            diff = arr[r] - arr[l];

            while (r + 1 <= N && diff < M) {
                r++;
                diff = arr[r] - arr[l];
            }

            if (diff >= M) {
                min = Math.min(min, diff);
            }
        }

        bw.write(min + " ");
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
