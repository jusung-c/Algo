import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M;
    static int[] selected;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        selected = new int[M + 1];
        used = new boolean[N + 1];

        rec_func(1, 1);

        br.close();
        bw.close();
    }

    static void rec_func(int k, int prev) throws IOException {
        if (k == M + 1) { // 다 골랐다!
            // selected[1...M] 배열이 새롭게 탐색된 결과
            for (int i = 1; i <= M; i++) {
                bw.write(selected[i]+" ");
            }
            bw.write("\n");

        } else {
            for (int cand = prev; cand <= N; cand++) {
                selected[k] = cand;
                rec_func(k + 1, cand);
            }

        }
    }
}

