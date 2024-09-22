import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int R, C, H;
    static int[][][] map, day;
    static int[][] dir = new int[][]{{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
    static class Point {
        int h, r, c;

        public Point(int h, int r, int c) {
            this.h = h;
            this.r = r;
            this.c = c;
        }
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][R][C];
        for (int h = 0; h < H; h++) {
            for (int r = 0; r < R; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < C; c++) {
                    map[h][r][c] = Integer.parseInt(st.nextToken());
                }
            }
        }

        day = new int[H][R][C];
        for (int h = 0; h < H; h++) {
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    day[h][r][c] = -1;
                }
            }
        }
    }

    private static void pro() throws IOException {
        // 익은 토마토들을 대상으로 BFS 진행
        bfs();

        int ans = -1;

        // 그게 아니라면 day의 최댓값을 출력
        for (int h = 0; h < H; h++) {
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    // 안 익은 토마토에 해당하는 day가 -1이 있을 경우 -1 출력
                    if (map[h][r][c] == 0 && day[h][r][c] == -1) {
                        bw.write("-1");
                        return;
                    }

                    ans = Math.max(ans, day[h][r][c]);
                }
            }
        }

        bw.write(ans + " ");
    }

    private static void bfs() {
        Queue<Point> que = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if (map[h][r][c] == 1) {
                        que.add(new Point(h, r, c));
                        day[h][r][c] = 0;
                    }
                }
            }
        }

        while (!que.isEmpty()) {
            Point p = que.poll();

            for (int d = 0; d < 6; d++) {
                int nh = p.h + dir[d][0];
                int nr = p.r + dir[d][1];
                int nc = p.c + dir[d][2];

                if (nh < 0 || nr < 0 || nc < 0 ||
                    nh >= H || nr >= R || nc >= C) continue;

                if (map[nh][nr][nc] != 0) continue;
                if (day[nh][nr][nc] != -1) continue;

                que.add(new Point(nh, nr, nc));
                day[nh][nr][nc] = day[p.h][p.r][p.c] + 1;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
