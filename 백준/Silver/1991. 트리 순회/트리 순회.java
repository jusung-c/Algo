import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int N;
    static int[][] list;
    static StringBuilder sb = new StringBuilder();

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        list = new int[27][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int node = st.nextToken().charAt(0) - 'A';

            for (int k = 0; k < 2; k++) {
                char child = st.nextToken().charAt(0);

                if (child != '.') list[node][k] = child - 'A';
                else list[node][k] = -1;
            }
        }
    }

    private static void pro() throws IOException {
        // 1. 전위 순회
        frontDfs(0);
        bw.newLine();

        // 2. 중위 순회
        midDfs(0);
        bw.newLine();

        // 3.후위 순회
        backDfs(0);
        bw.newLine();
    }

    private static void backDfs(int node) throws IOException {
        if (node == -1) return;
        backDfs(list[node][0]);
        backDfs(list[node][1]);
        bw.write((char) node + 'A');
    }

    private static void midDfs(int node) throws IOException {
        if (node == -1) return;
        midDfs(list[node][0]);
        bw.write((char) node + 'A');
        midDfs(list[node][1]);
    }

    private static void frontDfs(int node) throws IOException {
        if (node == -1) return;
        bw.write((char) node + 'A');
        frontDfs(list[node][0]);
        frontDfs(list[node][1]);
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
