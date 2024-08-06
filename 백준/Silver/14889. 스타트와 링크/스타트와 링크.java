import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static int min = Integer.MAX_VALUE;
    static int[] start, link;
    static boolean[] isUsed;
    static int[][] stat;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = N / 2;

        start = new int[M];
        isUsed = new boolean[N];
        stat = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                stat[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void pro(int k, int prev) throws IOException {
        // 종료 조건
        if (k == M) {
            int sub = calSub(start, isUsed);
            min = Math.min(min, sub);
            return;
        }

        for (int i = prev; i < N; i++) {
            if (isUsed[i]) continue;

            isUsed[i] = true;
            start[k] = i;

            pro(k + 1, i + 1);

            isUsed[i] = false;
            start[k] = 0;
        }
    }

    private static int calSub(int[] start, boolean[] isUsed) throws IOException {
        // link 팀 구하기
        link = new int[M];

        int index = 0;
        for (int i = 0; i < N; i++) {
            if (isUsed[i]) continue;
            link[index++] = i;
        }

        // 각 팀의 점수 차이 구하기
        int sub = Math.abs(getScore(start) - getScore(link));
//        System.out.println("sub = " + sub);
        return sub;
    }

    private static int getScore(int[] team) {
        int result = 0;

        for (int i = 0; i < M; i++) {
            for (int j = i; j < M; j++) {
                int x = team[i];
                int y = team[j];

                result += stat[x][y];
                result += stat[y][x];
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        init();

        pro(0, 0);

        bw.write(min+" ");

        bw.close();
    }
}
