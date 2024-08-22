import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N, x;
    static int[] arr;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        x = Integer.parseInt(br.readLine());
    }

    private static void pro() throws IOException {
        Arrays.sort(arr);

        int start = 0;
        int end = arr.length - 1;
        int answer = 0;

        while (end > start) {

            if (arr[start] + arr[end] == x) {
                start++;
                answer++;
            } else if (arr[start] + arr[end] > x) {
                end--;
            } else {
                start++;
            }
        }

        bw.write(answer + " ");
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
