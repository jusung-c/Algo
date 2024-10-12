import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int arrSize, target;
    static int[] arr;

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        arrSize = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        arr = new int[arrSize];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arrSize; i++) arr[i] = Integer.parseInt(st.nextToken());
    }

    private static void pro() throws IOException {
        int sum = 0, result = 0;

        for (int R = -1, L = 0; L < arrSize; L++) {
            if (L != 0) sum -= arr[L - 1];

            while (R + 1 < arrSize && sum < target) {
                sum += arr[++R];
            }

            if (sum == target) result++;
        }

        bw.write(result + " ");
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
