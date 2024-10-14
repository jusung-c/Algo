import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int S, P;
    static String input;
    static int[] ACGT, cnt;

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        input = br.readLine();

        ACGT = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) ACGT[i] = Integer.parseInt(st.nextToken());
    }

    private static void pro() throws IOException {
        int answer = 0;
        cnt = new int[4];
        int size = 0;

        for (int R = -1, L = 0; L < S; L++) {
            if (L != 0) {
                updateCnt(L - 1, -1);
                size--;
            }

            while (R + 1 < S && size < P) {
                R++;
                updateCnt(R, 1);
                size++;
            }

//            for (int a : cnt) bw.write(a + " ");
//            bw.newLine();

            if (checkMinCnt(cnt) && size == P) answer++;
        }

        bw.write(answer + " ");
    }

    private static boolean checkMinCnt(int[] cnt) {
        for (int i = 0; i < 4; i++) {
            if (cnt[i] < ACGT[i]) return false;
        }

        return true;
    }

    private static void updateCnt(int i, int sign) {
        switch (input.charAt(i)) {
            case 'A':
                cnt[0] += sign;
                break;
            case 'C':
                cnt[1] += sign;
                break;
            case 'G':
                cnt[2] += sign;
                break;
            case 'T':
                cnt[3] += sign;
                break;
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
