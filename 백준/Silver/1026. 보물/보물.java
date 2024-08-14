import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int[] A, answer;
    static Elem[] B;

    static class Elem implements Comparable<Elem>{
        int num, idx;

        public Elem(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(Elem o) {
            // 내림차순 정렬
            return o.num - num;
        }
    }

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        answer = new int[N];

        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        B = new Elem[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = new Elem(Integer.parseInt(st.nextToken()), i);
        }

    }

    private static void pro() throws IOException {
        int result = 0;

        // 오름 차순
        Arrays.sort(A);

        // 내림 차순
        Arrays.sort(B);

        for (int i = 0; i < N; i++) {
            answer[B[i].idx] = A[i];

            result += A[i] * B[i].num;
        }

        bw.write(result + " ");
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
