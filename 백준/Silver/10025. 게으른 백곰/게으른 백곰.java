import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ;
    static StringTokenizer st;
    static int N, dist;
    static int[] arr;

    public static void init() throws IOException {
        // 가장 적은 거리만 움직이고도 최대한 많은 얼음을 먹을 수 있도록
        // N(1 ≤ N ≤ 100000)개의 얼음 양동이들이
        // xi(0 ≤ xi ≤ 1,000,000)좌표마다 놓여 있고
        // 각 양동이 안에는 gi(1 ≤ gi ≤ 10,000)씩의 얼음이 들어 있다.
        // 현 위치에서 좌우로 K(1 ≤ K ≤ 2,000,000) 만큼 떨어진 양동이까지 닿을 수 있다.
        // 최적의 자리를 골랐을 때 얼음의 합은?

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dist = Integer.parseInt(st.nextToken()) * 2 + 1;
        arr = new int[1000001];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[x] = target;
        }
    }

    private static void pro() throws IOException {
        int sum = 0;
        int size = 0;
        int max = 0;

        for (int R = -1, L = 0; L < 1000001; L++) {
            if (L != 0) {
                sum -= arr[L - 1];
                size--;
            }

            while (R + 1 < 1000001 && size < dist) {
                sum += arr[++R];
                size++;
            }

            max = Math.max(max, sum);
        }

        bw.write(max + " ");
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
