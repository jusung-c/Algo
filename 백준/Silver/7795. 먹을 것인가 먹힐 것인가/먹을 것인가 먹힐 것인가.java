import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int T, N, M;
    static int[] A, B;


    private static void pro() throws IOException {
        // 1. B 오름차순 정렬
        Arrays.sort(B, 1, M + 1);

        // 2. A의 원소를 X로 두고 이분탐색을 통해 X보다 작은 원소의 개수 구하기
        int ans = 0;

        for (int i = 1; i <= N; i++) {
            ans += lower_bound(B, 1, M, A[i]);
        }

        System.out.println(ans);
    }

    // 배열 arr에서 X 미만의 수 중 가장 큰 수의 인덱스 반환하는 함수
    private static int lower_bound(int[] arr, int L, int R, int X) {
        int result = L - 1;
        int mid;
        while (L <= R) {
            mid = (L + R) / 2;

            if (arr[mid] >= X) {
                R = mid - 1;
            } else if (arr[mid] < X) {
                result = mid;
                L = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        init();

        br.close();
        bw.close();
    }

    public static void init() throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            A = new int[N + 1];
            B = new int[M + 1];

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            pro();

        }
    }
}
