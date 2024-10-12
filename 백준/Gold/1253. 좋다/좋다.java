import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int N;
    static int[] arr;

    public static void init() throws IOException {
        // N(1 ≤ N ≤ 2,000)개의 수열. 각 원소는 -10억 ~ 10억
        // "좋다": 어떤 수가 다른 수 2개의 합으로 나타낼 수 있는 경우
        // "좋은" 수의 개수를 구하라

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());
    }

    private static void pro() throws IOException {
        // 배열 정렬
        Arrays.sort(arr, 1, N + 1);

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (tp(i)) answer++;
        }

        bw.write(answer + " ");
    }

    private static boolean tp(int target) {
        // 계산할 때 자료형은 long을 써야한다.
        int L = 1;
        int R = N;
        long sum = 0;

        while (L < R) {
            // target인 경우는 제외
            if (L == target) L++;
            else if (R == target) R--;

            if (L >= R) break;

            sum = arr[L] + arr[R];
            if (sum == arr[target]) return true;
            else if (sum > arr[target]) R--;
            else L++;
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
