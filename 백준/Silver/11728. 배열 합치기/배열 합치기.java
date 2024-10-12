import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int N, M;
    static int[] A, B;

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];
        B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) B[i] = Integer.parseInt(st.nextToken());
    }

    private static void pro() throws IOException {
        int aIndex = 0;
        int bIndex = 0;
        int index = 0;
        int[] answer = new int[N + M];

        while (true) {
            if (aIndex == N || bIndex == M) break;

            if (A[aIndex] <= B[bIndex]) answer[index++] = A[aIndex++];
            else answer[index++] = B[bIndex++];
        }

        if (aIndex == N) for (int i=bIndex; i<M; i++) answer[index++] = B[i];
        if (bIndex == M) for (int i=aIndex; i<N; i++) answer[index++] = A[i];
        for (int i : answer) bw.write(i + " ");
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
