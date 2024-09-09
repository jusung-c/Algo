import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int N, grout_cnt;
    static String[] input;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static ArrayList<Integer> group;

    public static void init() throws IOException {

        N = Integer.parseInt(br.readLine());
        input = new String[N];

        for (int i = 0; i < N; i++) {
            input[i] = br.readLine();
        }

        visit = new boolean[N][N];
    }

    private static void pro() throws IOException {
        group = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 방문하지 않은 집 발견
                if (!visit[i][j] && input[i].charAt(j) == '1') {
                    // 단지 안 집 개수
                    grout_cnt = 0;

                    // 연결된 집 모두 탐색
                    dfs(i, j);

                    group.add(grout_cnt);
                }
            }
        }

        System.out.println(group.size());

        group.stream()
                .sorted()
                .forEach(System.out::println);
    }

    private static void dfs(int x, int y) {

        visit[x][y] = true;
        grout_cnt++;

        for (int d = 0; d < 4; d++) {
            int nx = x + dir[d][0];
            int ny = y + dir[d][1];

            // 새로 이동한 좌표 범위 체크
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

            // 새로 이동한 좌표에 집이 있는지 체크
            if (input[nx].charAt(ny) == '0') continue;

            // 방문 여부 체크
            if (visit[nx][ny]) continue;

            dfs(nx, ny);
        }

    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
