import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int r, c, k, w;
    static int[][] map;


    public static void init() throws IOException {
        // RxC(1 ≤ R, C ≤ 30) map
        // 최고 밝기 K(1 ≤ K ≤ 10,000)와 정수 W(1 ≤ W ≤ min(R, C)) 홀수가 주어진다.
        st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < c; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
    }

    private static void pro() throws IOException {
        int[][] newMap = new int[r - w + 1][c - w + 1];

        // 완전탐색
        for (int i = 0; i < r - w + 1; i++) {
            for (int j = 0; j < c - w + 1; j++) {
                newMap[i][j] = findMedian(i, j);
                bw.write(newMap[i][j] + " ");
            }
            bw.newLine();
        }

    }

    private static int findMedian(int a, int b) {
        List<Integer> arr = new ArrayList<>();

        for (int i = a; i < a + w; i++) {
            for (int j = b; j < b + w; j++) {
                arr.add(map[i][j]);
            }
        }

        int[] array = arr.stream().sorted().mapToInt(i -> i).toArray();
        return array[array.length / 2];
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
