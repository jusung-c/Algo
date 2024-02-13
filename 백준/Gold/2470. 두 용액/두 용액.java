import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[] list;

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        list = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() throws IOException {
        // list 정렬
        Arrays.sort(list, 1, N + 1);

        // 투 포인터
        int L = 1;
        int R = N;
        int r1 = 0;
        int r2 = 0;
        int ans = Integer.MAX_VALUE;

        // L == R의 경우는 한 용액만 남는 경우임
        while (L < R) {
            int sum = list[L] + list[R];

            // ans, r1, r2 갱신
            if (Math.abs(sum) < ans) {
                // 비교하기 쉽도록 절댓값으로 갱신
                ans = Math.abs(sum);
                r1 = list[L];
                r2 = list[R];
            }

            // 최소와 최대를 더했을 때 0보다 큰 경우
            if (sum > 0) {
                R--;

            // 최소와 최대를 더했을 때 0보다 작은 경우
            } else {
                L++;
            }
        }

        bw.write(r1+" "+r2);
    }

    public static void main(String[] args) throws IOException {
        init();

        pro();

        bw.close();
    }

}
