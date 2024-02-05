import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    0. 문제
        - N개의 정수로 이루어진 수열
        - 크기가 양수인 부분수열 중 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수
        - 1 ≤ N ≤ 20, |S| ≤ 1,000,000
        - 주어진 정수의 절댓값은 100,000을 넘지 않는다.

    1. 아이디어
        - 정답의 최대치 계산
            - N의 최대치는 20이고 부분수열의 개수는 최대 2^20개 이므로 int 타입
        - N개의 정수를 중복없이, 순서없이 합이 S가 되는 진부분수열 -> 조합 사용
        - 1~N 크기의 부분수열 전부 탐색 후 합이 S가 되는 경우 찾기

    2. 시간 복잡도
        - 조합의 시간복잡도 O(2^N)
        - 1~N번 도는 for문 안에 조합 알고리즘이 있으므로 총 O(N*2^N)
        - N의 최댓값이 20이므로 20*2^20 < 2초 라서 가능한 풀이법

 */

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N, S, result, sum;
    static int[] nums;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        result = 0;
        sum = 0;

        nums = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void pro(int k, int prev, int M) throws IOException {
        if (k == M + 1) {
            if (sum == S) result++;
        } else {
            for (int i = prev + 1; i <= N; i++) {
                int n = nums[i];
                sum += n;

                pro(k+1, i, M);

                sum -= n;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        for (int i = 1; i <= N; i++) {
            pro(1, 0, i);
        }

        System.out.println(result + " ");

        bw.close();
    }
}
