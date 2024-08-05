import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static int[] numbers;
    static LinkedHashSet<String> answer = new LinkedHashSet<>();

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
    }

    private static void pro(int k, String result) throws IOException {
        // 종료 조건
        if (k == M + 1) {
            answer.add(result);
            return;
        }

        for (int i = 1; i <= N; i++) {

            pro(k + 1, result + numbers[i] + " ");
        }

    }

    public static void main(String[] args) throws Exception {
        init();

        pro(1, "");

        for (String s : answer) {
            bw.write(s + "\n");
        }

        bw.close();
    }
}
