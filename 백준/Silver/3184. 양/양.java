import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int r, c, o_cnt, v_cnt, a, b;
    static String[] input;
    static boolean[][] visit;
    static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        o_cnt = 0;
        v_cnt = 0;

        visit = new boolean[r][c];
        input = new String[r];
        for (int i = 0; i < r; i++) {
            input[i] = br.readLine();
        }
    }

    private static void pro() throws IOException {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visit[i][j] && input[i].charAt(j) != '#') {
                    a = 0;
                    b = 0;

                    dfs(i, j);

                    if (a > b) {
                        o_cnt += a;
                    } else {
                        v_cnt += b;
                    }
                }
            }
        }

        bw.write(o_cnt + " " + v_cnt + " ");

    }

    private static void dfs(int x, int y) {
        visit[x][y] = true;
        if (input[x].charAt(y) == 'o') a++;
        if (input[x].charAt(y) == 'v') b++;

        for (int d = 0; d < 4; d++) {
            int nx = x + dir[d][0];
            int ny = y + dir[d][1];

            if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
            if (visit[nx][ny]) continue;
            if (input[nx].charAt(ny) == '#') continue;

            dfs(nx, ny);
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
