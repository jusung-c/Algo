import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, currentCnt, maxCnt;
    static Long max = Long.MIN_VALUE;
    static long[] nums;
    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        nums = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            nums[i] = Long.parseLong(br.readLine());
        }
    }

    private static void pro() {
        // 카드 정렬
        Arrays.sort(nums, 1, N + 1);

        // 첫번째 카드
        max = nums[1];
        maxCnt = 1;
        currentCnt = 1;

        // 두번째 카드부터 배열 전체를 돌면서 카운트
        for (int i = 2; i <= N; i++) {
            // 이전 값과 같으면
            if (nums[i] == nums[i - 1]) {
                // 현재 카운트 증가
                currentCnt++;

                // maxCnt, max 갱신
                if (maxCnt < currentCnt) {
                    maxCnt = currentCnt;
                    max = nums[i];
                }
            } else {
                // 1부터 다시 세기
                currentCnt = 1;
            }

        }


    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.write(max+" ");

        br.close();
        bw.close();
    }
}
