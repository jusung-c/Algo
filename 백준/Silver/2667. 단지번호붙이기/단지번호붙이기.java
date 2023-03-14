import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, group_cnt;
    static String[] a;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static ArrayList<Integer> group;

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        a = new String[N];

        for (int i = 0; i < N; i++) {
            a[i] = br.readLine();
        }

        visit = new boolean[N][N];
    }

    // x, y를 갈 수 있다는 걸 알고 방문한 상태
    static void dfs(int x, int y) {
        // 단지에 속한 집의 개수 증가, visit 체크
        group_cnt++;
        visit[x][y] = true;

        // 인접한 집으로 새로운 방문
        for (int k = 0; k < 4; k++) {
            // 좌표 이동
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            // 새로 이동한 좌표가 지도에 존재하는 지 확인
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

            // 새로 이동한 좌표에 집이 있는 지 확인
            if (a[nx].charAt(ny) == '0') continue;

            // 새로 이동한 좌표의 집을 방문한 적이 있는 지 확인
            if(visit[nx][ny]) continue;

            dfs(nx, ny);
        }

    }

    static void bfs(int x, int y) {
        Queue<Point> que = new LinkedList<>();

        group_cnt = 1;
        que.add(new Point(x, y));
        visit[x][y] = true;

        while (!que.isEmpty()) {
            Point p = que.poll();

            for (int k = 0; k < 4; k++) {
                // 좌표 이동
                int nx = p.x + dir[k][0];
                int ny = p.y + dir[k][1];

                // 새로 이동한 좌표가 지도에 존재하는 지 확인
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                // 새로 이동한 좌표에 집이 있는 지 확인
                if (a[nx].charAt(ny) == '0') continue;

                // 새로 이동한 좌표의 집을 방문한 적이 있는 지 확인
                if(visit[nx][ny]) continue;

                que.add(new Point(nx, ny));
                visit[nx][ny] = true;
                group_cnt++;
            }
        }



    }

    private static void pro() throws IOException {
        group = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 방문하지 않은 집을 발견했을 때!
                if (!visit[i][j] && a[i].charAt(j) == '1') {
                    // 단지 안 집 개수
                    group_cnt = 0;
                    // 그 집을 기준으로 연결된 모든 집 탐색
                    bfs(i, j);

                    group.add(group_cnt);
                }
            }
        }

        Collections.sort(group);

        bw.write(group.size() + "\n");

        Iterator<Integer> iter = group.iterator();
        while (iter.hasNext()) {
            bw.write(iter.next() + "\n");
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
