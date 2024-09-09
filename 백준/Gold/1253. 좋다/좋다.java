import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int[] arr;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void pro() throws IOException {
        Arrays.sort(arr, 1, N + 1);

        int cnt = 0;

        for (int target = 1; target <= N; target++) {
            int R = N;
            int sum = 0;

            for (int L = 1; L <= N; L++) {
                if (L == target) continue;
                if (R == target) R--;

                sum = arr[L] + arr[R];

                while (R - 1 > L && sum > arr[target]) {
                    R--;
                    if (R == target) continue;
                    sum = arr[L] + arr[R];
                }

                if (sum == arr[target]) {
//                    bw.write(arr[L] + " " + arr[R] + " target: " + arr[target]);
//                    bw.newLine();
                    cnt++;
                    break;
                }
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
