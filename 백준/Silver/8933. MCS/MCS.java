import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int length;
    static int[] info;
    static String input;

    public static void init() throws IOException {
        // A, G, T, C로만 이루어진 문자열
        // 같은 부분 문자열을 찾아야 한다.

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            length = Integer.parseInt(st.nextToken());
            input = st.nextToken();

            info = new int[4];

            int answer = findMCS();
            bw.write(answer + " ");
            bw.newLine();
        }
    }

    private static int findMCS() throws IOException {
        Map<Integer, Integer> map = new HashMap<>();
        int size = 0;
        int sum = 0;
        int max = 0;

        for (int R = -1, L = 0; L < input.length(); L++) {
            if (L != 0) {
                count(input.charAt(L - 1), -1);
                size--;
            }

            while (R + 1 < input.length() && size < length) {
                R++;
                count(input.charAt(R), 1);
                size++;
            }

            if (size == length) {
                sum = getSum();
                int value = map.getOrDefault(sum, 0) + 1;
                map.put(sum, value);
                max = Math.max(max, value);
            }
        }

        return max;
    }

    private static int getSum() {
        return info[0] + info[1] * 600 + info[2] * 600 * 600 + info[3] * 600 * 600 * 600;

    }

    public static void count(char c, int sign) {
        switch (c) {
            case 'A':
                info[0] += sign;
                break;
            case 'G':
                info[1] += sign;
                break;
            case 'T':
                info[2] += sign;
                break;
            case 'C':
                info[3] += sign;
                break;
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        bw.close();
    }
}
