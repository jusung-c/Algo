import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int N, t;
    static int[] arr;

    public static void init() throws IOException {
        // 혈중 알코올 농도를 유지한 시간을 출력하라
        // 매 시간마다 술을 먹는다. 몇 시간까지 지정된 농도를 유지하는지 출력하라

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
    }

    private static void pro() throws IOException {
        int sum = 0;
        int size = 0;
        int cnt = 0;
        int max = 0;

        for (int R = -1, L = 0; L < N; L++) {
            if (L!=0) {
                sum -= arr[L - 1];
//                System.out.println("이전 값을 지웁니다! = " + sum + " L-1 = " + (L-1) + " R = " + R);
                size--;
            }

            while (R + 1 < N && size < t) {
                R++;
//                System.out.println("sum = " + sum);
                sum += arr[R];
//                System.out.println("R = " + arr[R] + " 결과 = " + arr[R] +" sum = " + sum);

                if (sum >= 129 && sum <= 138) cnt++;

                size++;
            }
        }

        bw.write(cnt + " ");

    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
