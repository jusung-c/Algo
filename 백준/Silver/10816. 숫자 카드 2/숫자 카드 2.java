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
            int n = Integer.parseInt(st.nextToken());

            int left = left(1, N, n);
            int right = right(1, N, n);

            bw.write(right - left - 1 + " ");
        }

    }

    private static int right(int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) start = mid + 1;
            else if (arr[mid] < target) start = mid + 1;
            else end = mid -1;
        }

        return start;
    }

    private static int left(int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) end = mid - 1;
            else if (arr[mid] > target) end = mid -1;
            else start = mid + 1;
        }

        return end;
    }

    private static void pro() throws IOException {


    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}

