import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ;
    static StringTokenizer st;
    static int R, C;
    static Point S, D;
    static int[][] wave, hog;
    static String[] input;
    static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        wave = new int[R][C];
        hog = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                wave[i][j] = -1;
                hog[i][j] = -1;
            }
        }

        input = new String[R];
        for (int i = 0; i < R; i++) {
            input[i] = br.readLine();
        }
    }

    private static void pro() throws IOException {
        // 물이 잠기는 시간 계산하기
        waveBfs();

//        bw.write("웨이브 정보 \n");
//        for (int i = 0; i < R; i++) {
//            for (int j = 0; j < C; j++) {
//                bw.write(wave[i][j] + " ");
//            }
//            bw.newLine();
//        }
//        bw.newLine();

        // 고슴도치 시작점 넣기
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (input[i].charAt(j) == 'S') S = new Point(i, j);
                if (input[i].charAt(j) == 'D') D = new Point(i, j);
            }
        }

        // 고슴도치 대피 경로 탐색
        hogBfs(S);
//
//        bw.write("고슴도치 정보 \n");
//        for (int i = 0; i < R; i++) {
//            for (int j = 0; j < C; j++) {
//                bw.write(dist[i][j] + " ");
//            }
//            bw.newLine();
//        }
//        bw.newLine();

        if (hog[D.x][D.y] == -1) bw.write("KAKTUS");
        else bw.write(hog[D.x][D.y] + " ");
    }

    private static void waveBfs() {
        Queue<Point> que = new LinkedList<>();

        // 모든 물을 시작점으로 넣기
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (input[i].charAt(j) == '*') {
                    que.add(new Point(i, j));
                    wave[i][j] = 0;
                }
            }
        }

        while (!que.isEmpty()) {
            Point p = que.poll();

            // 가능한 모든 경로 BFS 탐색
            for (int d = 0; d < 4; d++) {

                int nx = p.x + dir[d][0];
                int ny = p.y + dir[d][1];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (wave[nx][ny] != -1) continue;
                if (input[nx].charAt(ny) != '.') continue;

                que.add(new Point(nx, ny));
                wave[nx][ny] = wave[p.x][p.y] + 1;
            }
        }

    }

    private static void hogBfs(Point start) {
        Queue<Point> que = new LinkedList<>();

        que.add(start);
        hog[start.x][start.y] = 0;

        while (!que.isEmpty()) {
            Point p = que.poll();
            for (int d = 0; d < 4; d++) {
                int nx = p.x + dir[d][0];
                int ny = p.y + dir[d][1];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (hog[nx][ny] != -1) continue;

                // 이동할 수 없는 지역이면 제외
                if (input[nx].charAt(ny) != '.' && input[nx].charAt(ny) != 'D') continue;

                // 물이 잠길 예정이면서 도착지점이 아닌 경우 제외 -> 물에 잠길 예정이어도 도착지점이면 이동 가능
                if (hog[p.x][p.y] + 1>= wave[nx][ny] && wave[nx][ny] != -1) continue;

                que.add(new Point(nx, ny));
                hog[nx][ny] = hog[p.x][p.y] + 1;
            }

        }
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
