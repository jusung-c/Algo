import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int N, M;
    static int[] arr;

    public static void init() throws IOException {
        // N개의 배열
        // 아래 조건에 맞게 선택해야 한다.
        // 1. 연속된 M개 선택
        // 2. 연속된 M개에서 (9*M/10)개 이상의 값이 하나의 값으로 같아야 한다.
        // 도로에 배너를 걸 수 있는가?
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
    }

    private static void pro() throws IOException {
        int cnt = 0;
        int size = 0;
        int maxIndex = -1;
        int max = -1;
        int[] cntArray = new int[1000001];
        boolean answer = false;

        double d = (double) 9 * M / 10;
        int i = d % 1 > 0 ? (int) d + 1 : (int) d;

        for (int R = -1, L = 0; L < N; L++) {
            if (L != 0) {
                cntArray[arr[L - 1]]--;
                if (maxIndex == arr[L-1]) max--;
                size--;
            }

            while (R + 1 < N && size < M) {
                R++;
                cntArray[arr[R]]++;
                if (cntArray[arr[R]] > max) {
                    max = cntArray[arr[R]];
                    maxIndex = arr[R];
                }
                size++;
            }

            if (max >= i) {
                answer = true;
                break;
            }
        }

        bw.write(answer ? "YES" : "NO");
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
