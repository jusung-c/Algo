import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    0. 문제

    1. 아이디어

    2. 시간 복잡도

 */

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static int[] arr;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, 1, N + 1);

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= M; i++) {
            bSearch(Integer.parseInt(st.nextToken()));
        }

    }

    private static void bSearch(int target) throws IOException {
        int start = 1;
        int end = N;
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                result = 1;
                break;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        bw.write(result + " ");

    }

    public static void main(String[] args) throws Exception {
        init();

        bw.close();
    }
}
