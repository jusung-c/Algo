import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] map;

    public static void init() throws IOException {
        map = new int[9][9];

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }

    private static void pro(int row, int col) throws IOException {
        // 한 열을 다 채운 경우
        if (col == 9) {
            pro(row + 1, 0);
            return;
        }

        // 케이스 찾은 경우
        if (row == 9) {
            print(map);
            bw.close();
            System.exit(0);
        }


        // 탐색
        // 0으로 비어있는 경우 탐색 시작
        if (map[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (check(row, col, i)) {
                    map[row][col] = i;

                    pro(row, col + 1);
                }
            }

            map[row][col] = 0;
            return;

        }

        // 이미 숫자가 적혀있는 경우 다음열로 ㄱㄱ
        pro(row, col + 1);
    }

    private static boolean check(int row, int col, int i) {
        // 행 체크
        for (int c = 0; c < 9; c++) {
            if (map[row][c] == i) {
                return false;
            }
        }

        // 열 체크
        for (int r = 0; r < 9; r++) {
            if (map[r][col] == i) {
                return false;
            }
        }

        // 3x3 체크
        int x = row / 3 * 3;
        int y = col / 3 * 3;

        for (int a = x; a <= x + 2; a++) {
            for (int b = y; b <= y + 2; b++) {
                if (map[a][b] == i) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void print(int[][] map) throws IOException {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                bw.write(map[i][j] + " ");
            }
            bw.write("\n");
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        pro(0, 0);

        br.close();
        bw.close();
    }
}
