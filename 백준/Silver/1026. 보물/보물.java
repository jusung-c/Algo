import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    0. 문제
        - N인 정수 배열 A와 B
        - S = A[0] × B[0] + ... + A[N-1] × B[N-1]
        - S가 최소가되도록 A 재배열

    1. 아이디어
        - B를 인덱스와 함께 ArrayList에 저장 후 정렬한다.
        - 정렬된 인덱스의 값을 이용해 A를 재배열한다.

    2. 시간 복잡도

 */

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N, ans;
    static int[] A;
    static Point[] B;

    static class Point implements Comparable<Point> {
        int num, idx;

        @Override
        public int compareTo(Point o) {
            return o.num - num;
        }
    }

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new Point[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            B[i] = new Point();
            B[i].num = Integer.parseInt(st.nextToken());
            B[i].idx = i;
        }

    }

    private static void pro() throws IOException {
        ans = 0;

        Arrays.sort(B);
        Arrays.sort(A);

        for (int i = 0; i < N; i++) {
            ans += A[i] * B[i].num;
        }

    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.write(ans + " ");

        bw.close();
    }
}
