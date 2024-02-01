import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int min = Integer.MAX_VALUE;
    static int[] start, visit;
    static int[][] score;


    public static void init() throws IOException {
        // N은 짝수
        N = Integer.parseInt(br.readLine());
        M = N / 2;

        start = new int[M + 1];
        visit = new int[N + 1];

        // 점수판
        score = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void pro(int k, int prev) throws IOException {
        if (k == M + 1) {
            // start와 link의 점수를 계산
            cal();

        } else {
            for (int i = prev + 1; i <= N; i++) {
                if (visit[i] == 1) continue;

                start[k] = i;
                visit[i] = 1;

                pro(k + 1, i);

                start[k] = 0;
                visit[i] = 0;
            }
        }


    }

    private static void cal() throws IOException {
        int[] link = new int[M + 1];
        int index = 1;
        for (int i = 1; i <= N; i++) {
            if (visit[i] == 0) {
                link[index] = i;
                index++;
            }
        }

        int start_score = 0;
        int link_score = 0;

        for (int i = 1; i <= M; i++) {
            for (int j = i + 1; j <= M; j++) {
                int s_1 = start[i];
                int s_2 = start[j];
                int l_1 = link[i];
                int l_2 = link[j];

                start_score += score[s_1][s_2];
                start_score += score[s_2][s_1];

                link_score += score[l_1][l_2];
                link_score += score[l_2][l_1];
            }
        }

//        bw.write(+start_score +  "****" + link_score + "\n");


        min = Math.min(min, Math.abs(start_score - link_score));

    }

    public static void main(String[] args) throws Exception {
        init();

        pro(1, 0);

        bw.write(min + " ");

        br.close();
        bw.close();
    }
}
