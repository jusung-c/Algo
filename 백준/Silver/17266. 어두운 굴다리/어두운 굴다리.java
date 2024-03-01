import java.io.*;
import java.util.StringTokenizer;

/*
    0. 문제
        - 가로등 M개를 설치했을 때 0~N의 길을 모두 밝혀라
        - 가로등의 높이 H를 최소로 하라

    1. 아이디어
        - 높이가 H일 때 M개의 가로등으로 0~N을 모두 밝힐 수 있는가?
        -

    2. 시간 복잡도

 */

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static int[] point;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        // 길의 길이
        N = Integer.parseInt(br.readLine());

        // 가로등 개수
        M = Integer.parseInt(br.readLine());

        // 가로등의 위치
        point = new int[M + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= M; i++) {
            point[i] = Integer.parseInt(st.nextToken());
        }

    }

    private static void pro() throws IOException {
        int start = point[1];
        int end = N;
        int result = 0;

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

    private static boolean yesOrNo(int H) {
        int prev_end = point[1] + H;

        for (int i = 2; i <= M; i++) {
            int start = point[i] - H;
            int end = point[i] + H;

            if (start > prev_end) return false;
            else prev_end = end;
        }

        return prev_end >= N;
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
