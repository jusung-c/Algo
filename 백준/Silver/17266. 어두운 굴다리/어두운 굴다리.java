import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static int[] points;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        points = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static boolean yesOrNo(int h) {

        if (points[0] - h > 0 || points[points.length-1] + h < N)
            return false;

        for (int i = 0; i < M - 1; i++) {
            if (points[i] + 2*h < points[i + 1]) return false;
        }

        return true;
    }

    private static void pro() throws IOException {
        int start = 0;
        int end = N;
        int result = N;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (yesOrNo(mid)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        bw.write(result + " ");

    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
