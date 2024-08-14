import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int[] P;
    static Elem[] B;

    private static class Elem implements Comparable<Elem>{
        int num, idx;

        public Elem(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(Elem o) {
            if (num != o.num) return num - o.num;
            return idx - o.idx;
        }
    }

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        P = new int[N];
        B = new Elem[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = new Elem(Integer.parseInt(st.nextToken()), i);
        }
    }

    private static void pro() throws IOException {
        Arrays.sort(B);

        for (int i = 0; i < N; i++) {
            P[B[i].idx] = i;
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
