import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
    0. 문제
        - NxN 크기의 도시의 각 칸은 빈칸(0), 치킨집(2), 집(1) 중 하나이다.
        - 집과 가장 가까운 치킨집까지의 거리를 치킨 거리라고 할 때
        도시의 치킨 거리는 모든 집의 치킨 거리의 합이다.
        - 도시에서 가장 수익을 많이 낼 수 있는 치킨집의 개수는 최대 M개일 때
        M개를 제외한 치킨집은 폐업시킬 예정이다.
        - 어떻게 M개의 치킨집을 골라야 도시의 치킨 거리가 최소가 될지 구하라

    1. 아이디어
        - 치킨집들 중 중복없이 순서없이 M개의 치킨집을 고른다.
        - 치킨 거리를 계산한 후 최소값을 구한다.

    2. 시간 복잡도
        -

 */

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static int answer = Integer.MAX_VALUE;
    static int[] selected;
    static ArrayList<Pair> house = new ArrayList<>();
    static ArrayList<Pair> chicken = new ArrayList<>();

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void init() throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        selected = new int[M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                int n = Integer.parseInt(st.nextToken());

                if (n == 1) house.add(new Pair(i, j));
                if (n == 2) chicken.add(new Pair(i, j));
            }
        }


    }

    private static void pro(int k, int prev) throws IOException {
        if (k == M + 1) {
            answer = Math.min(answer, calculate());
        } else {
            for (int i = prev; i < chicken.size(); i++) {
                selected[k] = i;

                pro(k + 1, i + 1);

                selected[k] = 0;
            }
        }

    }

    // 치킨 거리 계산
    private static int calculate() {
        int sum = 0;

        for (Pair p1 : house) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= M; j++) {
                Pair p2 = chicken.get(selected[j]);

                min = Math.min(min, Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y));

            }
            sum += min;
        }

        return sum;
    }

    public static void main(String[] args) throws Exception {
        init();

        pro(1, 0);

        bw.write(answer + "");

        bw.close();
    }
}
