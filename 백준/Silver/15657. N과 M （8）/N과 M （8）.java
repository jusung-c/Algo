import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
    0. 문제
        - N개의 자연수 중 M개를 고른 수열
        - 중복해서 고를 수 있다.
        - 고른 수열은 비내림차순이어야 한다.

    1. 아이디어
        - k번째 자리에 i라는 수를 골랐으면 다음 탐색 범위 시작 위치를 i로 설정
        - 이렇게 하면 중복으로 고를 수도 있고 오름차순 수열로만 나타낼 수 있다.

    2. 시간 복잡도
        - N과 M의 최댓값이 8이므로 8! < 1초 가능한 접근법

 */

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;

    static int N, M;
    static int[] num, selected;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N + 1];
        selected = new int[M + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);
    }

    // 1 7 8 9
    // 1 1

    private static void pro(int k, int prev) throws IOException {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                bw.write(selected[i] + " ");
            }
            bw.write("\n");
        } else {
            for (int i = prev; i <= N; i++) {
                int n = num[i];
                selected[k] = n;

                pro(k + 1, i);

                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        pro(1, 1);

        bw.close();
    }
}
