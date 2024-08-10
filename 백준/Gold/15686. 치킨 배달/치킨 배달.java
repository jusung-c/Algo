import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M, houseCnt, chickenCnt;
    static int min = Integer.MAX_VALUE;
    static int[] selected;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        selected = new int[M];

        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 1; c <= N; c++) {
                switch (Integer.parseInt(st.nextToken())) {
                    case 0:
                        break;
                    case 1:
                        houses.add(new int[]{r, c});
                        break;
                    case 2:
                        chickens.add(new int[]{r, c});
                        break;
                }
            }
        }

        houseCnt = houses.size();
        chickenCnt = chickens.size();
    }

    private static void pro(int k, int prev) throws IOException {
        if (k == M) {
            min = Math.min(min, getDist());
            return;
        }

        for (int i = prev; i < chickenCnt; i++) {
            selected[k] = i;

            pro(k + 1, i + 1);

            selected[k] = 0;
        }

    }

    private static int getDist() throws IOException {
        int result = 0;

        for (int[] h : houses) {
            int minDist = Integer.MAX_VALUE;

            for (int i = 0; i < M; i++) {
                int[] c = chickens.get(selected[i]);

                minDist = Math.min(minDist, Math.abs(c[0] - h[0]) + Math.abs(c[1] - h[1]));
            }

            result += minDist;
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        init();

        pro(0, 0);
        bw.write(min + " ");

        bw.close();
    }
}
