import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static ArrayList<Integer>[] dots;

    static int toLeft(int color, int idx) {
        if (idx == 0) {
            return Integer.MAX_VALUE;
        } else {
            return dots[color].get(idx) - dots[color].get(idx - 1);
        }
    }

    static int toRight(int color, int idx) {
        if (idx == dots[color].size() - 1) {
            return Integer.MAX_VALUE;
        } else {
            return dots[color].get(idx + 1) - dots[color].get(idx);
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dots = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            dots[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int point, color;
            point = Integer.parseInt(st.nextToken());
            color = Integer.parseInt(st.nextToken());

            dots[color].add(point);
        }

    }

    public static void pro() throws IOException {
        for (int i = 1; i <= N; i++) {
            Collections.sort(dots[i]);
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < dots[i].size(); j++) {
                int left = toLeft(i, j);
                int right = toRight(i, j);

                ans += Math.min(left, right);
            }
        }

        bw.write(ans+" ");
    }

    public static void main(String[] args) throws IOException {
        input();

        pro();

        bw.close();
    }



}