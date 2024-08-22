import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static int[] arr;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());

            // 큰 수 중 가장 작은 값의 인덱스 구하기
            int bigIndex = bigSearch(target);

            // 작은 수 중 가장 큰 값의 인덱스 구하기
            int smallIndex = smallSearch(target);

            bw.write(bigIndex - smallIndex - 1 + " ");
        }

    }

    private static int smallSearch(int target) {
        int start = 0;
        int end = arr.length - 1;
        int result = start - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            // 작은 수 중 가장 큰 값의 인덱스 구하기
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

    private static int bigSearch(int target) throws IOException {
        int start = 0;
        int end = arr.length - 1;
        int result = end + 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            // 큰 수 중 가장 작은 값의 인덱스 구하기
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

    public static void main(String[] args) throws Exception {
        init();

        bw.close();
    }
}
