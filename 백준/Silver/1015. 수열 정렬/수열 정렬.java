import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    0. 문제
        - 0~N-1의 수를 한번씩 포함하고 있는 수열 P
        - 길이가 N인 배열 A
        - B[P[i]] = A[i]
            - P[i]는 인덱스
        - 배열 A가 주어졌을 때 수열 P를 적용한 결과가 비내림차순이 되는 수열을 구하라

    1. 아이디어
        - 가장 단순한 풀이: O(N^2)
            - 배열 A의 모든 원소에 대해 배열 B의 모든 원소를 돌면서 같은 값을 찾는다.
            - 찾으면 그 인덱스 값을 P 배열에 넣어준다.
            - 같은 값을 대비해 방문처리를 해준다.

    2. 시간 복잡도

 */

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int[] A, P, visit;
    static Elem[] B;

    static class Elem implements Comparable<Elem> {
        int num, idx;

        @Override
        public int compareTo(Elem o) {
            // 비내림차순
            if (num != o.num) return num - o.num;
            else return idx - o.idx;
        }
    }

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());

        A = new int[N];
        P = new int[N];
        visit = new int[N];

        B = new Elem[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());

            A[i] = a;

            B[i] = new Elem();
            B[i].num = a;
            B[i].idx = i;
        }
    }

    // A: 2 3 1
    // B: (0,2), (1,3), (2,1)
    // 정렬 후 B: (2,1), (0,2), (1,3)

    private static void pro() throws IOException {
        Arrays.sort(B);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i] == B[j].num && visit[j] == 0) {
                    visit[j] = 1;
                    P[i] = j;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        for (int i : P) {
            bw.write(i + " ");
        }

        bw.close();
    }
}
