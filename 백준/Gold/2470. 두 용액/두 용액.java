import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int[] list;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);
    }

    private static void pro() throws IOException {
        int A = 0;
        int B = 0;
        int sum = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int target = list[i] * -1;


            // 후보지 2개
            int indexA = binarySearch(i + 1, N - 1, target);
            int indexB = indexA - 1;

            // 각 후보들에 대해 범위 체크 후 최솟값 갱신
            if (indexA > i && indexA < N) {
                if (sum > Math.abs(list[i] + list[indexA])) {
                    A = list[i];
                    B = list[indexA];
                    sum = Math.abs(list[i] + list[indexA]);
                }
            }

            if (indexB > i && indexB < N) {
                if (sum > Math.abs(list[i] + list[indexB])) {
                    A = list[i];
                    B = list[indexB];
                    sum = Math.abs(list[i] + list[indexB]);
                }
            }

        }
        bw.write(A + " " + B + " ");

    }

    private static int binarySearch(int start, int end, int target) {

        int result = N;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (list[mid] == target) {
                start = mid + 1;
            } else if (list[mid] > target) {
                end = mid - 1;
                result = mid;
            } else if (list[mid] < target) {
                start = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
