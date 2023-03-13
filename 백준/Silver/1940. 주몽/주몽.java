import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int[] arr;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

    }

    private static void pro() throws IOException {
        // 배열 정렬하기
        Arrays.sort(arr, 1, N + 1);

        // 투 포인터 사용
        int ans = 0;
        int L = 1;
        int R = N;

        while (L < R) {
            int sum = arr[L] + arr[R];

            if (sum == M) {
                ans++;
                L++;
            } else if (sum > M) {
                R--;
            } else {
                L++;
            }
        }

        bw.write(ans + " ");


    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
