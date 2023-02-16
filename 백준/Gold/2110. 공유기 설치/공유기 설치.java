import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, C;
    static int house[];

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        house = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
    }

    // D 만큼 거리 차이가 난다면 C 만큼의 공유기 설치 가능? -> Yes or No
    static boolean determination(int D) {
        int cnt = 1;
        int last = house[1];

        for (int i = 2; i <= N; i++) {
            if (house[i] - last >= D) {
                cnt++;
                last = house[i];
            }
        }

        return cnt >= C;
    }

    private static void pro() throws IOException {
        // 집 정렬하기
        Arrays.sort(house, 1, N + 1);

        // 이분 탐색 범위 1~10억
        int start = 1;
        int end = 1000000000; // 10억
        int result = 0;

        // 이분 탐색으로 마지막 Yes 찾아내기!
        while (start <= end) {
            int mid = (start + end) / 2;

            // Yes일 경우!
            if (determination(mid)) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        bw.write(result+" ");

    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        br.close();
        bw.close();
    }
}
