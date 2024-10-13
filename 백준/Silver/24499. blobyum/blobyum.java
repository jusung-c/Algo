import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int N, K;
    static int[] arr;

    public static void init() throws IOException {
        // N(10만 이하 자연수)개를 원형으로 나열
        // 각 원소는 값은 100이하
        // 연속으로 배치되어 있는 K개를 선택했을 때 최대의 합을 구하라

        // 정답의 최대치
        // N이 최대 10만개이고 전부 최대치인 100일 때 연속으로 최대치인 10만개를 먹는 경우
        // 10만 * 100 -> int 범위 안

        // 시간 복잡도: 슬라이딩 윈도우 문제 -> O(N)

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N*2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            arr[i + N] = arr[i];
        }
    }

    private static void pro() throws IOException {
        // K size를 유지하면서 합의 값을 구하고 최댓값을 갱신한다.
        int sum = 0;
        int size = 0;
        int max = Integer.MIN_VALUE;

        // 한 바퀴 돌면서 합을 구하고, 최댓값 갱신
        for (int L = 0, R = -1; L < 2 * N; L++) {
            // sum 갱신
            if (L != 0) {
                sum -= arr[L - 1];
                size--;
            }

            while (R + 1 < 2 * N && size < K) {
                sum += arr[++R];
                size++;
            }

//            bw.write("L = " + L + " R = " + R + " sum = " + sum + " size = " + size);
//            bw.newLine();

            // 최댓값 갱신
            max = Math.max(max, sum);
        }

        bw.write(max + " ");

    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
