import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int[] arr;

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");

        // 카드 오름차순 정렬
        Arrays.sort(arr, 1, N + 1);

        for (int i = 1; i <= M; i++) {
            int val = Integer.parseInt(st.nextToken());
            // target 미만의 수 중 가장 큰 수의 인덱스 구하기
            int small = S_Search(1, N, val);


            // target 초과의 수 중 가장 작 수의 인덱스 구하기
            int big = B_Search(1, N, val);

            bw.write(big - small - 1 + " ");
        }

    }

    private static int B_Search(int start, int end, int target) {
        int result = end + 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                start = mid + 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                result = mid;
                end = mid - 1;
            }
        }

        return result;
    }

    private static int S_Search(int start, int end, int target) {
        int result = start - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                end = mid - 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                result = mid;
                start = mid + 1;
            }
        }

        return result;
    }

    private static void pro() {



    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        br.close();
        bw.close();
    }
}
