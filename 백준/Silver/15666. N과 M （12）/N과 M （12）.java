import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;
/*
    0. 문제
        - N개의 자연수 중에서 M개를 고른 수열
        - 같은 수를 여러 번 골라도 된다.
        - 고른 수열은 비내림차순이어야 한다.

    1. 아이디어
        - 주어진 수 정렬
        - k번째 자리에 i라는 수를 골랐으면 다음 탐색 범위 시작 위치를 i로 설정
        - LinkedHashSet으로 중복 방지

    2. 시간 복잡도
        - N과 M의 최댓값이 8이므로 8! < 1초 가능한 접근법

 */

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;

    static int N, M;
    static int[] num;
    static LinkedHashSet<String> map = new LinkedHashSet<>();

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);
    }

    private static void pro(int k, int prev, String numString) throws IOException {
        if (k == M + 1) {
            map.add(numString);
        } else {
            for (int i = prev; i <= N; i++) {
                int n = num[i];

                pro(k + 1, i, numString + n + " ");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        pro(1, 1, "");

        for (String s : map) {
            bw.write(s + "\n");
        }

        bw.close();
    }
}
