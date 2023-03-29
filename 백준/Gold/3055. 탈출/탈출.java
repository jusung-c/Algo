import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int[][] dist_water, dist_hedgehog;
    static String[] a;
    static int[][] dir = new int[][]{
            {1, 0}, {0, 1},
            {-1, 0}, {0, -1}
    };


    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist_water = new int[N][M];
        dist_hedgehog = new int[N][M];

        a = new String[N];

        for (int i = 0; i < N; i++) {
            a[i] = br.readLine();
        }

    }

    private static void pro() throws IOException {
        // 물 찾아서 BFS 돌리기
        bfs_water();

        // 고슴도치 탈출 시도
        bfs_hedgehog();

        // 정답 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (a[i].charAt(j) == 'D' ) {
                    if (dist_hedgehog[i][j] == -1) {
                        bw.write("KAKTUS" + " ");
                    } else {
                        bw.write(dist_hedgehog[i][j] + " ");
                    }
                }
            }
        }
    }

    private static void bfs_hedgehog() throws IOException {
        Queue<Integer> Q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist_hedgehog[i][j] = -1;

                if (a[i].charAt(j) == 'S' ) {
                    Q.add(i);
                    Q.add(j);

                    dist_hedgehog[i][j] = 0;
                }
            }
        }

        // BFS 시작
        while (!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();

            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (a[nx].charAt(ny) != '.' && a[nx].charAt(ny) != 'D' ) continue;
                if (dist_water[nx][ny] != -1 && dist_water[nx][ny] <= dist_hedgehog[x][y] + 1)
                    continue;  // 물에 잠기지는 않는가?
                if (dist_hedgehog[nx][ny] != -1) continue;

                Q.add(nx);
                Q.add(ny);

                dist_hedgehog[nx][ny] = dist_hedgehog[x][y] + 1;
            }
        }
    }

    private static void bfs_water() {
        Queue<Integer> Q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist_water[i][j] = -1;

                if (a[i].charAt(j) == '*' ) {
                    Q.add(i);
                    Q.add(j);

                    dist_water[i][j] = 0;
                }
            }
        }

        // BFS 시작
        while (!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();

            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (a[nx].charAt(ny) != '.' ) continue;
                if (dist_water[nx][ny] != -1) continue;

                Q.add(nx);
                Q.add(ny);
                dist_water[nx][ny] = dist_water[x][y] + 1;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
