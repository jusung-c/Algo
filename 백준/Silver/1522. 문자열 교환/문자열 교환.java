import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int N, target;
    static String s;

    public static void init() throws IOException {
        s = br.readLine();
        N = s.length();
        target = (int) s.chars().filter(c -> c == 'a').count();
    }

    private static void pro() throws IOException {
        // aabbaaabaaba
        // a의 개수: 8개
        // a의 개수 크기만큼의 부분 수열이 b를 가장 적게 포함하는 경우를 찾기

        int size = 0;
        int bCnt = 0;
        int min = Integer.MAX_VALUE;

        for (int R = -1, L = 0; L < N; L++) {
            if (L != 0) {
                if (s.charAt(L-1) == 'b') bCnt--;
                size--;
            }

            while (size < target) {
                R = (R + 1) % N;
                if (s.charAt(R) == 'b') bCnt++;
                size++;
            }

            if (size == target) min = Math.min(min, bCnt);
        }

        bw.write(min + " ");
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
