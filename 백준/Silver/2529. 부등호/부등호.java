import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
    0. 문제
        - 부등호 수열을 만족하는 숫자 수열 찾기. 부등호의 개수는 k (2 ≤ k ≤ 9)
        - 그 수열은 서로 다른 숫자로 이루어짐
        - 숫자 수열의 최댓값, 최솟값을 구하라

    1. 아이디어
        - 0~9의 숫자중 k-1개를 중복없이 순서 있게 탐색
        - 부등호 수열을 만족하는지 확인
        - 최댓값, 최솟값 업데이트

    2. 시간 복잡도

 */

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int k, M;
    static int[] selected, visited;
    static char[] list;
    static ArrayList<String> result = new ArrayList<>();
    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        // 부등호 수
        k = Integer.parseInt(br.readLine());

        // 부등호 수열
        list = new char[k + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= k; i++) {
            list[i] = st.nextToken().charAt(0);
        }

        // 선택할 수
        M = k + 1;

        // 선택된 수열
        selected = new int[M + 1];

        // 방문 체크
        visited = new int[10];
    }

    private static void pro(int k) throws IOException {
        if (k == M + 1) {
            if (checkValid()) {
                StringBuilder s = new StringBuilder();
                for (int i = 1; i <= M; i++) {
                    s.append(selected[i]);
                }

                result.add(String.valueOf(s));
            }
        } else {
            for (int i = 0; i <= 9; i++) {
                if (visited[i] == 1) continue;
                selected[k] = i;
                visited[i] = 1;

                pro(k + 1);

                selected[k] = 0;
                visited[i] = 0;
            }
        }
    }

    private static boolean checkValid() {
        boolean result = true;

        for (int i = 1; i <= k; i++) {
            switch (list[i]) {
                case '<':
                    if (!(selected[i] < selected[i + 1])) return false;
                    break;
                case '>':
                    if (!(selected[i] > selected[i + 1])) return false;
                    break;
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        init();

        pro(1);

        bw.write(result.get(result.size()-1) + "\n");
        bw.write(result.get(0) +" ");

        bw.close();
    }
}
