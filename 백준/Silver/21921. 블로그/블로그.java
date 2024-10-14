import java.io.*;
import java.security.Key;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int N, day;
    static int[] arr;

    public static void init() throws IOException {
        // X일 동안 가장 많이 들어온 방문자 수와 그 기간들을 알고 싶다.
        // X일 동안 가장 많이 들어온 방문자 수를 구하라
        // 만약 최대 방문자 수가 0명이라면 SAD를 출력하라

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        day = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
    }

    private static void pro() throws IOException {
        int sum = 0;
        int size = 0;
        int cnt = 0;
        int max = 0;

        for (int R = -1, L = 0; L < N - day + 1; L++) {
            if (L != 0) {
                sum -= arr[L - 1];
                size--;
            }

            while (R + 1 < N && size < day) {
                sum += arr[++R];
                size++;
            }

            if (size == day) {
                if (max < sum) {
                    max = sum;
                    cnt = 1;
                } else if (max == sum) {
                    cnt++;
                }
            }
        }

        if (max == 0) {
            bw.write("SAD");
        } else {
            bw.write(max + " ");
            bw.newLine();
            bw.write(cnt + " ");
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
